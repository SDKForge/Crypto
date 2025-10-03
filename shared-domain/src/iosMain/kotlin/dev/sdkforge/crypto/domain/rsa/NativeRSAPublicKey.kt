@file:Suppress("ktlint:standard:class-signature")
@file:OptIn(ExperimentalForeignApi::class)

package dev.sdkforge.crypto.domain.rsa

import dev.sdkforge.crypto.domain.NativePublicKey
import kotlinx.cinterop.ExperimentalForeignApi

internal data class NativeRSAPublicKey(
    override val key: platform.Security.SecKeyRef,
) : RSAPublicKey, NativePublicKey(key)

val platform.Security.SecKeyRef.asNativeRSAPublicKey: RSAPublicKey
    get() = NativeRSAPublicKey(this)
