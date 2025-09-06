# SDKForge Crypto

[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.20--Beta2-blue.svg)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android-API%2021+-green.svg)](https://developer.android.com/)
[![iOS](https://img.shields.io/badge/iOS-12.0+-orange.svg)](https://developer.apple.com/ios/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Platform](https://img.shields.io/badge/Platform-Android%20%7C%20iOS-lightgrey.svg)](https://kotlinlang.org/docs/multiplatform.html)

A modern Kotlin Multiplatform cryptographic library for secure key generation, encryption, and digital signatures across Android and iOS platforms. This library provides a unified API for cryptographic operations while leveraging platform-specific security features like Android Keystore and iOS Keychain.

## 🚀 Features

- **Kotlin Multiplatform**: Write once, run on Android and iOS
- **Cryptographic Key Generation**: RSA and Elliptic Curve (EC) key pair generation
- **Platform-Specific Security**: Android Keystore and iOS Keychain integration
- **Unified Crypto API**: Consistent interface across platforms for cryptographic operations
- **Modern Architecture**: Clean, modular structure with separate modules for different concerns
- **Type-Safe Design**: Strongly typed cryptographic primitives and operations
- **Comprehensive Testing**: Unit tests, integration tests, and performance benchmarks
- **Code Quality**: KtLint, dependency guard, and binary compatibility validation
- **Documentation**: Automated API documentation with Dokka
- **CI/CD Ready**: GitHub Actions workflows for automated builds and publishing
- **Performance Monitoring**: Built-in benchmarking tools

## 📱 Supported Platforms

- **Android**: API 21+ (Android 5.0+)
- **iOS**: 12.0+
- **Kotlin**: 2.2.20-Beta2+
- **Gradle**: 8.0+

## 🏗️ Project Structure

```
SDKForge-Crypto/
├── app-android/         # Android sample application
├── app-ios/             # iOS sample application
├── app-shared/          # Shared sample UI components (Compose Multiplatform)
├── shared/              # Main crypto library with all components
├── shared-core/         # Core shared functionality
├── shared-domain/       # Cryptographic domain models and operations
├── shared-template/     # Template for shared modules
├── build-logic/         # Gradle build logic and conventions
├── internal-benchmark/  # Performance benchmarks
└── internal-ktlint/     # Custom ktlint rules
```

## 🛠️ Installation

> **Note**: This project is currently in development and not yet published to any repository. Installation instructions will be available once the project is published.

### Future Installation (Coming Soon)

Once published, you'll be able to install the SDK using:

#### Gradle (Kotlin DSL)
```kotlin
dependencies {
    implementation("dev.sdkforge.crypto:crypto:0.0.1")
    implementation("dev.sdkforge.crypto:crypto-domain:0.0.1")
    implementation("dev.sdkforge.crypto:crypto-core:0.0.1")
}
```

#### Gradle (Groovy)
```groovy
dependencies {
    implementation 'dev.sdkforge.crypto:crypto:0.0.1'
    implementation 'dev.sdkforge.crypto:crypto-domain:0.0.1'
    implementation 'dev.sdkforge.crypto:crypto-core:0.0.1'
}
```

#### Maven
```xml
<dependency>
    <groupId>dev.sdkforge.crypto</groupId>
    <artifactId>crypto</artifactId>
    <version>0.0.1</version>
</dependency>
<dependency>
    <groupId>dev.sdkforge.crypto</groupId>
    <artifactId>crypto-domain</artifactId>
    <version>0.0.1</version>
</dependency>
```

## 🚀 Quick Start

### Prerequisites

- **Java Development Kit (JDK)**: Version 17 or higher
- **Android Studio**: Latest stable version (for Android development)
- **Xcode**: Latest stable version (for iOS development, macOS only)
- **Kotlin**: Version 2.2.20-Beta2 or higher
- **Gradle**: Version 8.0 or higher

### Development Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/SDKForge/Crypto.git SDKForgeCrypto
   cd SDKForgeCrypto
   ```

2. **Build the project**:
   ```bash
   ./gradlew build
   ```

3. **Run tests**:
   ```bash
   ./gradlew lint ktlintCheck dependencyGuard apiCheck
   ```

4. **Generate documentation**:
   ```bash
   ./gradlew dokkaHtml
   ```

### Using the Crypto Library

This library provides cryptographic functionality for Kotlin Multiplatform applications:

1. **Add dependencies** to your project
2. **Import the crypto modules** you need
3. **Use the unified API** for cryptographic operations
4. **Leverage platform-specific security** features automatically

## 📖 Usage

### Basic Crypto Operations

The library provides a unified interface for cryptographic operations across platforms:

```kotlin
// Common interface (shared-domain/src/commonMain/kotlin/dev/sdkforge/crypto/domain/KeyGenerator.kt)
expect object KeyGenerator {
    suspend fun generate(
        algorithm: KeyAlgorithm,
        identifier: String,
        keySize: Int,
    ): KeyPair
}

// Supported algorithms
enum class KeyAlgorithm {
    RSA,
    EC,
}
```

### Key Generation Examples

#### Generate RSA Key Pair
```kotlin
// Generate a 2048-bit RSA key pair
val keyPair = KeyGenerator.generate(
    algorithm = KeyAlgorithm.RSA,
    identifier = "my-rsa-key",
    keySize = 2048
)

println("Public Key: ${keyPair.publicKey.algorithm}")
println("Private Key: ${keyPair.privateKey.algorithm}")
```

#### Generate Elliptic Curve Key Pair
```kotlin
// Generate an EC key pair (typically 256-bit)
val ecKeyPair = KeyGenerator.generate(
    algorithm = KeyAlgorithm.EC,
    identifier = "my-ec-key",
    keySize = 256
)
```

### Platform-Specific Implementations

The library automatically uses platform-specific security features:

#### Android Implementation
- Uses Android Keystore for secure key storage
- Leverages hardware security modules when available
- Integrates with Android's security architecture

#### iOS Implementation
- Uses iOS Keychain for secure key storage
- Leverages Secure Enclave when available
- Integrates with iOS security framework

### Library Version Information

Access library version information through the Library object:

```kotlin
// shared/src/commonMain/kotlin/dev/sdkforge/crypto/Library.kt
data object Library {
    const val VERSION = "0.0.1"
}

// Usage
val sdkVersion = Library.VERSION
```

## 🧪 Testing

### Run All Tests
```bash
./gradlew test
```

### Run Platform-Specific Tests
```bash
# Android tests
./gradlew app-android:test

# iOS tests
./gradlew app-ios:test
```

### Performance Benchmarks
```bash
./gradlew internal-benchmark:connectedAndroidTest
```

## 📚 Documentation

- **API Documentation**: Generated with Dokka
- **Contributing Guide**: [CONTRIBUTING.md](CONTRIBUTING.md)
- **Code of Conduct**: [CODE_OF_CONDUCT.md](.github/CODE_OF_CONDUCT.md)
- **Security Policy**: [SECURITY.md](.github/SECURITY.md)

## 🔧 Development

### Adding New Modules

1. Create a new module in the `shared-*` directory
2. Apply the appropriate plugins in `build.gradle.kts`
3. Update the main `shared` module to export the new module
4. Add tests and documentation

### Code Style

This project uses KtLint for code formatting. Run the following to check and fix code style:

```bash
./gradlew ktlintCheck
./gradlew ktlintFormat
```

### Dependency Management

The project uses dependency guard to prevent dependency drift:

```bash
./gradlew dependencyGuard
```

## 🤝 Contributing

We welcome contributions! Please see our [Contributing Guide](CONTRIBUTING.md) for details.

### Before Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests
5. Ensure all checks pass
6. Submit a pull request

### Code of Conduct

This project adheres to a [Code of Conduct](.github/CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code.

## 🔒 Security

We take security seriously. Please report security vulnerabilities to [volodymyr.nevmerzhytskyi@sdkforge.dev](mailto:volodymyr.nevmerzhytskyi@sdkforge.dev).

**Do NOT create public GitHub issues for security vulnerabilities.**

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

- **Documentation**: Check our [documentation](https://github.com/SDKForge/crypto#readme)
- **Issues**: [GitHub Issues](https://github.com/SDKForge/crypto/issues)
- **Discussions**: [GitHub Discussions](https://github.com/SDKForge/Crypto/discussions)
- **Email**: [volodymyr.nevmerzhytskyi@sdkforge.dev](mailto:volodymyr.nevmerzhytskyi@sdkforge.dev)

## 🗺️ Roadmap

- [ ] **Encryption/Decryption** - Add symmetric and asymmetric encryption capabilities
- [ ] **Digital Signatures** - Implement signing and verification functionality
- [ ] **Hash Functions** - Add cryptographic hash functions (SHA-256, SHA-512, etc.)
- [ ] **Key Exchange** - Implement key exchange protocols (ECDH, etc.)
- [ ] **Publishing Setup** - Configure Maven Central or other repository publishing
- [ ] **CI/CD Pipeline** - Automated publishing workflows
- [ ] **Web platform support** - Extend to web platforms
- [ ] **Desktop platform support** - Add desktop (Windows, macOS, Linux) support
- [ ] **Enhanced performance monitoring** - Advanced benchmarking and profiling
- [ ] **More cryptographic algorithms** - Additional encryption and signature algorithms
- [ ] **Advanced configuration options** - Flexible crypto library configuration
- [ ] **Documentation site** - Dedicated documentation website

## 🙏 Acknowledgments

- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) team
- [Android Security](https://developer.android.com/topic/security) team
- [iOS Security](https://developer.apple.com/security/) team
- [JetBrains](https://www.jetbrains.com/) for excellent tooling
- All contributors and community members

---

**Made with ❤️ by the SDKForge Team**
