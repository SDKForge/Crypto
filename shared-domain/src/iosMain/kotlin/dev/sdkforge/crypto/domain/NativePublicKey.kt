@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain

import kotlinx.cinterop.ExperimentalForeignApi
import platform.Security.SecKeyRef

@OptIn(ExperimentalForeignApi::class)
internal data class NativePublicKey(
    private val key: SecKeyRef?,
) : PublicKey, Key by NativeIOSKey(key)
