@file:Suppress("ktlint:standard:class-signature")
@file:OptIn(ExperimentalForeignApi::class)

package dev.sdkforge.crypto.domain.rsa

import dev.sdkforge.crypto.domain.NativePrivateKey
import kotlinx.cinterop.ExperimentalForeignApi

internal data class NativeRSAPrivateKey(
    override val key: platform.Security.SecKeyRef,
) : RSAPrivateKey, NativePrivateKey(key)

val platform.Security.SecKeyRef.asNativeRSAPrivateKey: RSAPrivateKey
    get() = NativeRSAPrivateKey(this)
