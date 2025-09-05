@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain.rsa

import dev.sdkforge.crypto.domain.Key
import dev.sdkforge.crypto.domain.NativeIOSKey
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Security.SecKeyRef

@OptIn(ExperimentalForeignApi::class)
internal data class NativeRSAPrivateKey(
    private val key: SecKeyRef?,
) : RSAPrivateKey, Key by NativeIOSKey(key)
