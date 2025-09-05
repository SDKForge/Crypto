@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain.rsa

import dev.sdkforge.crypto.domain.Key
import dev.sdkforge.crypto.domain.NativeAndroidKey

internal data class NativeRSAPublicKey(
    private val key: java.security.interfaces.RSAPublicKey,
) : RSAPublicKey, Key by NativeAndroidKey(key)
