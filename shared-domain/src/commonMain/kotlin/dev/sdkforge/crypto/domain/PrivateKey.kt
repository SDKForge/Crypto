package dev.sdkforge.crypto.domain

expect class PrivateKey : Key {
    override val algorithm: String
    override val encoded: ByteArray?
}
