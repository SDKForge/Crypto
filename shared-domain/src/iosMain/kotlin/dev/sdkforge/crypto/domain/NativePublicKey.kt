@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain

import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
internal open class NativePublicKey(
    internal open val key: platform.Security.SecKeyRef,
) : PublicKey, Key by NativeIOSKey(key)

// TODO: rethink this approach
@OptIn(ExperimentalForeignApi::class)
val PublicKey.asNativePublicKey: platform.Security.SecKeyRef
    get() = (this as NativePublicKey).key
