package dev.sdkforge.crypto.domain

import java.security.PublicKey

actual class PublicKey(private val key: PublicKey) : Key by NativeAndroidKey(key)
