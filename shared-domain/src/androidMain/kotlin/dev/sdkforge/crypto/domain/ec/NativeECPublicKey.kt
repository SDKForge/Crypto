@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain.ec

import dev.sdkforge.crypto.domain.NativePublicKey

internal data class NativeECPublicKey(
    override val key: java.security.interfaces.ECPublicKey,
) : ECPublicKey, NativePublicKey(key) {

    override val order: String
        get() = key.params.order.toString()
}

val java.security.interfaces.ECPublicKey.asNativeECPublicKey: ECPublicKey
    get() = NativeECPublicKey(this)
