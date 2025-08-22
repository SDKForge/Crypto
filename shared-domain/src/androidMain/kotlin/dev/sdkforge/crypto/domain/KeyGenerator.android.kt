package dev.sdkforge.crypto.domain

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyPairGenerator

actual object KeyGenerator {
    actual suspend fun generate(
        algorithm: KeyAlgorithm,
        identifier: String,
        keySize: Int,
    ): KeyPair {
        val generator: KeyPairGenerator = KeyPairGenerator.getInstance(
            algorithm.asNativeKeyAlgorithm,
            KEYSTORE_ANDROID,
        )

        val keyGenParameterSpec = KeyGenParameterSpec.Builder(
            identifier,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT,
        )
            .setKeySize(keySize)
            .build()

        generator.initialize(keyGenParameterSpec)
        val keyPair = generator.generateKeyPair()

        return KeyPair(
            publicKey = PublicKey(key = keyPair.public),
            privateKey = PrivateKey(key = keyPair.private),
        )
    }
}

private const val KEYSTORE_ANDROID = "AndroidKeyStore"
