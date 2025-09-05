@file:Suppress("ktlint:standard:function-signature", "ktlint:standard:function-expression-body")

package dev.sdkforge.crypto.domain

import cnames.structs.__CFDictionary
import cnames.structs.__CFString
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.usePinned
import kotlinx.cinterop.value
import platform.CoreFoundation.CFDictionaryGetValue
import platform.CoreFoundation.CFErrorRefVar
import platform.Foundation.CFBridgingRelease
import platform.Foundation.NSData
import platform.Security.SecKeyCopyAttributes
import platform.Security.SecKeyCopyExternalRepresentation
import platform.Security.SecKeyRef
import platform.Security.kSecAttrKeyType
import platform.posix.memcpy

@OptIn(ExperimentalForeignApi::class)
internal data class NativeIOSKey(private val key: SecKeyRef?) : Key {

    @OptIn(ExperimentalForeignApi::class)
    private val attributes by lazy { SecKeyCopyAttributes(key) }

    override val algorithm: String
        get() {
            val value = attributes[kSecAttrKeyType]

            return value.toString()
        }

    override val encoded: ByteArray?
        get() = memScoped {
            val keyExportError = alloc<CFErrorRefVar>()
            val keyRepresentation = SecKeyCopyExternalRepresentation(key = key, error = keyExportError.ptr)
            when (keyExportError.value) {
                null -> (CFBridgingRelease(keyRepresentation) as NSData).toByteArray()
                else -> null
            }
        }
}

@OptIn(ExperimentalForeignApi::class)
private operator fun CPointer<__CFDictionary>?.get(key: CPointer<__CFString>?): CPointer<out CPointed>? {
    return CFDictionaryGetValue(theDict = this, key = key)
}

@OptIn(ExperimentalForeignApi::class)
private fun NSData.toByteArray(): ByteArray {
    return ByteArray(length.toInt()).apply { usePinned { memcpy(it.addressOf(0), bytes, length) } }
}
