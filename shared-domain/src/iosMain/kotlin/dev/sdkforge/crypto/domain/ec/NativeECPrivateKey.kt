@file:Suppress("ktlint:standard:class-signature")
@file:OptIn(ExperimentalForeignApi::class)

package dev.sdkforge.crypto.domain.ec

import dev.sdkforge.crypto.domain.NativePrivateKey
import kotlinx.cinterop.ExperimentalForeignApi

internal data class NativeECPrivateKey(
    override val key: platform.Security.SecKeyRef,
) : ECPrivateKey, NativePrivateKey(key) {

    override val order: String
        get() = TODO("Not yet implemented")
}

val platform.Security.SecKeyRef.asNativeECPrivateKey: ECPrivateKey
    get() = NativeECPrivateKey(this)
