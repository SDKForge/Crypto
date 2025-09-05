@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain.ec

import dev.sdkforge.crypto.domain.Key
import dev.sdkforge.crypto.domain.NativeAndroidKey

internal data class NativeECPublicKey(
    private val key: java.security.interfaces.ECPublicKey,
) : ECPublicKey, Key by NativeAndroidKey(key) {

    override val order: String
        get() = key.params.order.toString()
}
