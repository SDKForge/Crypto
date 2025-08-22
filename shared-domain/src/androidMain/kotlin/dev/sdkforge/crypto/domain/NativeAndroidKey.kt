package dev.sdkforge.crypto.domain

internal class NativeAndroidKey(private val key: java.security.Key) : Key {
    override val algorithm: String get() = key.algorithm
    override val encoded: ByteArray? get() = key.encoded
}
