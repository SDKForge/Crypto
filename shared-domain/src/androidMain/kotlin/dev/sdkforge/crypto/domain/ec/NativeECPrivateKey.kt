@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain.ec

import dev.sdkforge.crypto.domain.NativePrivateKey

internal data class NativeECPrivateKey(
    override val key: java.security.interfaces.ECPrivateKey,
) : ECPrivateKey, NativePrivateKey(key) {

    override val order: String
        get() = key.params.order.toString()
}

val java.security.interfaces.ECPrivateKey.asNativeECPrivateKey: ECPrivateKey
    get() = NativeECPrivateKey(this)
