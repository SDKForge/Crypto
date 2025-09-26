@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain.rsa

import dev.sdkforge.crypto.domain.NativePublicKey

internal data class NativeRSAPublicKey(
    override val key: java.security.interfaces.RSAPublicKey,
) : RSAPublicKey, NativePublicKey(key)

val java.security.interfaces.RSAPublicKey.asNativeRSAPublicKey: RSAPublicKey
    get() = NativeRSAPublicKey(this)
