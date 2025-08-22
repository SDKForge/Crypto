package dev.sdkforge.crypto.domain

import cnames.structs.__CFString
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Security.kSecAttrKeyTypeEC
import platform.Security.kSecAttrKeyTypeRSA

@OptIn(ExperimentalForeignApi::class)
internal val KeyAlgorithm.asNativeKeyAlgorithm: CPointer<__CFString>?
    get() = when (this) {
        KeyAlgorithm.RSA -> kSecAttrKeyTypeRSA
        KeyAlgorithm.EC -> kSecAttrKeyTypeEC
    }
