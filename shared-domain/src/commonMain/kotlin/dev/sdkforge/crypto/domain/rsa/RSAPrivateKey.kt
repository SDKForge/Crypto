@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain.rsa

import dev.sdkforge.crypto.domain.PrivateKey

interface RSAPrivateKey : PrivateKey, RSAKey
