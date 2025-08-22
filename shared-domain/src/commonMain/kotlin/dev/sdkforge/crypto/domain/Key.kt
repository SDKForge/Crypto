package dev.sdkforge.crypto.domain

interface Key {
    val algorithm: String
    val encoded: ByteArray?
}
