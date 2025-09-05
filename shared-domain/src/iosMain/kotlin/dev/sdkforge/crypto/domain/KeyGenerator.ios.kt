@file:Suppress("ktlint:standard:function-signature", "ktlint:standard:function-expression-body")

package dev.sdkforge.crypto.domain

import cnames.structs.__CFDictionary
import cnames.structs.__CFString
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValuesRef
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.cstr
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import platform.CoreFoundation.CFDictionaryAddValue
import platform.CoreFoundation.CFDictionaryCreateMutable
import platform.Foundation.CFBridgingRelease
import platform.Foundation.CFBridgingRetain
import platform.Foundation.NSData
import platform.Foundation.NSNumber
import platform.Foundation.create
import platform.Security.SecKeyGeneratePair
import platform.Security.SecKeyRefVar
import platform.Security.kSecAttrApplicationTag
import platform.Security.kSecAttrIsPermanent
import platform.Security.kSecAttrKeySizeInBits
import platform.Security.kSecAttrKeyType
import platform.Security.kSecPrivateKeyAttrs
import platform.Security.kSecPublicKeyAttrs
import platform.darwin.noErr

actual object KeyGenerator {
    @OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
    actual suspend fun generate(
        algorithm: KeyAlgorithm,
        identifier: String,
        keySize: Int,
    ): KeyPair = memScoped {
        val privateKeyAttributes = createCFDictionary(capacity = 2).apply {
            this[kSecAttrIsPermanent] = retained { NSNumber(bool = false) }
            this[kSecAttrApplicationTag] = retained { NSData.create(bytes = identifier.cstr.ptr, length = identifier.length.toULong()) }
        }
        val publicKeyAttributes = createCFDictionary(capacity = 1).apply {
            this[kSecAttrIsPermanent] = CFBridgingRetain(NSNumber(bool = false))
        }
        val keyPairAttributes = createCFDictionary(capacity = 4).apply {
            this[kSecAttrKeyType] = algorithm.asNativeKeyAlgorithm
            this[kSecAttrKeySizeInBits] = retained { NSNumber(int = keySize) }
            this[kSecPublicKeyAttrs] = publicKeyAttributes
            this[kSecPrivateKeyAttrs] = privateKeyAttributes
        }

        val publicKey = alloc<SecKeyRefVar>()
        val privateKey = alloc<SecKeyRefVar>()

        val keyGenerationResultCode = SecKeyGeneratePair(
            parameters = keyPairAttributes,
            publicKey = publicKey.ptr,
            privateKey = privateKey.ptr,
        )

        CFBridgingRelease(publicKeyAttributes)
        CFBridgingRelease(privateKeyAttributes)
        CFBridgingRelease(keyPairAttributes)

        if (keyGenerationResultCode == noErr.toInt() && publicKey.value != null && privateKey.value != null) {
            KeyPair(privateKey = NativePrivateKey(key = privateKey.value), publicKey = NativePublicKey(key = publicKey.value))
        } else {
            throw IllegalStateException("Error during key generation.")
        }
    }
}

@OptIn(ExperimentalForeignApi::class)
private fun createCFDictionary(capacity: Long): CPointer<__CFDictionary>? {
    return CFDictionaryCreateMutable(allocator = null, capacity = capacity, keyCallBacks = null, valueCallBacks = null)
}

@OptIn(ExperimentalForeignApi::class)
private operator fun CPointer<__CFDictionary>?.set(key: CPointer<__CFString>?, value: CValuesRef<*>?) {
    CFDictionaryAddValue(theDict = this, key = key, value = value)
}

@OptIn(ExperimentalForeignApi::class)
private fun retained(function: () -> Any): CPointer<out CPointed>? {
    return CFBridgingRetain(function.invoke())
}
