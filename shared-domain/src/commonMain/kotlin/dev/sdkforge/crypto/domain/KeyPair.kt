@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain

data class KeyPair(
    val publicKey: PublicKey,
    val privateKey: PrivateKey,
)
