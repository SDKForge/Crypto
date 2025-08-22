package dev.sdkforge.crypto.domain

expect object KeyGenerator {
    suspend fun generate(
        algorithm: KeyAlgorithm,
        identifier: String,
        keySize: Int,
    ): KeyPair
}
