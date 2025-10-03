@file:Suppress("ktlint:standard:class-signature")
@file:OptIn(ExperimentalForeignApi::class)

package dev.sdkforge.crypto.domain

import kotlinx.cinterop.ExperimentalForeignApi

internal open class NativePrivateKey(
    internal open val key: platform.Security.SecKeyRef,
) : PrivateKey, Key by NativeIOSKey(key)

// TODO: rethink this approach
val PrivateKey.asNativePrivateKey: platform.Security.SecKeyRef
    get() = (this as NativePrivateKey).key
