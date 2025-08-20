package dev.sdkforge.crypto.core

interface Platform {
    val name: String
    val version: String
}

expect val currentPlatform: Platform
