package dev.sdkforge.crypto.domain

import java.security.PrivateKey

actual data class PrivateKey(private val key: PrivateKey) : Key by NativeAndroidKey(key)
