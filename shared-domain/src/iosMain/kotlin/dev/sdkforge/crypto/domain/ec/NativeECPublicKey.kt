@file:Suppress("ktlint:standard:class-signature")
@file:OptIn(ExperimentalForeignApi::class)

package dev.sdkforge.crypto.domain.ec

import dev.sdkforge.crypto.domain.NativePublicKey
import kotlinx.cinterop.ExperimentalForeignApi

internal data class NativeECPublicKey(
    override val key: platform.Security.SecKeyRef,
) : ECPublicKey, NativePublicKey(key) {

    override val order: String
        get() = TODO("Not yet implemented")
}

val platform.Security.SecKeyRef.asNativeECPublicKey: ECPublicKey
    get() = NativeECPublicKey(this)
