package dev.sdkforge.crypto.domain

import android.security.keystore.KeyProperties

internal val KeyAlgorithm.asNativeKeyAlgorithm: String
    get() = when (this) {
        KeyAlgorithm.RSA -> KeyProperties.KEY_ALGORITHM_RSA
        KeyAlgorithm.EC -> KeyProperties.KEY_ALGORITHM_EC
    }
