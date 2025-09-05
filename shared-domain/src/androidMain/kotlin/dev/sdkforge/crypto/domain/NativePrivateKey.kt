@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain

internal data class NativePrivateKey(
    internal val key: java.security.PrivateKey,
) : PrivateKey, Key by NativeAndroidKey(key)

// TODO: rethink this approach
val PrivateKey.asNativePrivateKey: java.security.PrivateKey
    get() = (this as NativePrivateKey).key
