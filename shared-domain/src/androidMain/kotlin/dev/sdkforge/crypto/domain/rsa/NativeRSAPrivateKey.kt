@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain.rsa

import dev.sdkforge.crypto.domain.NativePrivateKey

internal data class NativeRSAPrivateKey(
    override val key: java.security.interfaces.RSAPrivateKey,
) : RSAPrivateKey, NativePrivateKey(key)

val java.security.interfaces.RSAPrivateKey.asNativeRSAPrivateKey: RSAPrivateKey
    get() = NativeRSAPrivateKey(this)
