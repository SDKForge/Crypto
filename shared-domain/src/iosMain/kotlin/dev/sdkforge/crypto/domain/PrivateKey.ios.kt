package dev.sdkforge.crypto.domain

import kotlinx.cinterop.ExperimentalForeignApi
import platform.Security.SecKeyRef

@OptIn(ExperimentalForeignApi::class)
actual data class PrivateKey(private val key: SecKeyRef?) : Key by NativeIOSKey(key)
