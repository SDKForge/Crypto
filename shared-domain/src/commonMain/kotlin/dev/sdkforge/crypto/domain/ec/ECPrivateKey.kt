@file:Suppress("ktlint:standard:class-signature")

package dev.sdkforge.crypto.domain.ec

import dev.sdkforge.crypto.domain.PrivateKey

interface ECPrivateKey : PrivateKey, ECKey
