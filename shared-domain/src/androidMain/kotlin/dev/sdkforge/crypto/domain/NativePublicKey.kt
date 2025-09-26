@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain

internal open class NativePublicKey(
    internal open val key: java.security.PublicKey,
) : PublicKey, Key by NativeAndroidKey(key)

// TODO: rethink this approach
val PublicKey.asNativePublicKey: java.security.PublicKey
    get() = (this as NativePublicKey).key
