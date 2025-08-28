package dev.sdkforge.crypto.domain

import java.security.PublicKey

actual data class PublicKey(private val key: PublicKey) : Key by NativeAndroidKey(key)
