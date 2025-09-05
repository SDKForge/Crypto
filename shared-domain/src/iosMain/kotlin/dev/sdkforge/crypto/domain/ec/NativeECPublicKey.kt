@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain.ec

import dev.sdkforge.crypto.domain.Key
import dev.sdkforge.crypto.domain.NativeIOSKey
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Security.SecKeyRef

@OptIn(ExperimentalForeignApi::class)
internal data class NativeECPublicKey(
    private val key: SecKeyRef?,
) : ECPublicKey, Key by NativeIOSKey(key) {

    override val order: String
        get() = TODO("Not yet implemented")
}
