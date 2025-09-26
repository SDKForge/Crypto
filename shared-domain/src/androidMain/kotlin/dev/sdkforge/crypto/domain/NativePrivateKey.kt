@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain

internal open class NativePrivateKey(
    internal open val key: java.security.PrivateKey,
) : PrivateKey, Key by NativeAndroidKey(key)

// TODO: rethink this approach
val PrivateKey.asNativePrivateKey: java.security.PrivateKey
    get() = (this as NativePrivateKey).key
