package dev.sdkforge.crypto.domain

expect class PublicKey : Key {
    override val algorithm: String
    override val encoded: ByteArray?
}
