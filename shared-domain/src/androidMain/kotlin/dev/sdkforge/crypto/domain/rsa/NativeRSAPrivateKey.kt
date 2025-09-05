@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain.rsa

import dev.sdkforge.crypto.domain.Key
import dev.sdkforge.crypto.domain.NativeAndroidKey

internal data class NativeRSAPrivateKey(
    private val key: java.security.interfaces.RSAPrivateKey,
) : RSAPrivateKey, Key by NativeAndroidKey(key)
