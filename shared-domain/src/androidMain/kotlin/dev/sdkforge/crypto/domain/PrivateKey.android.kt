package dev.sdkforge.crypto.domain

import java.security.PrivateKey

actual class PrivateKey(private val key: PrivateKey) : Key by NativeAndroidKey(key)
