@file:OptIn(ExperimentalForeignApi::class)

package dev.sdkforge.crypto.domain

import cnames.structs.__CFString
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Security.kSecAttrKeyTypeECSECPrimeRandom
import platform.Security.kSecAttrKeyTypeRSA

internal val KeyAlgorithm.asNativeKeyAlgorithm: CPointer<__CFString>?
    get() = when (this) {
        KeyAlgorithm.RSA -> kSecAttrKeyTypeRSA
        KeyAlgorithm.EC -> kSecAttrKeyTypeECSECPrimeRandom
    }
