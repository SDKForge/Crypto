package dev.sdkforge.crypto.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.sdkforge.crypto.domain.KeyAlgorithm
import dev.sdkforge.crypto.domain.KeyGenerator
import dev.sdkforge.crypto.domain.KeyPair
import kotlin.time.Duration
import kotlin.time.measureTime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke

@Composable
fun App(
    modifier: Modifier = Modifier,
) = ApplicationTheme {
    var rsaKey by remember { mutableStateOf<KeyPair?>(null) }
    var generationTime by remember { mutableStateOf<Duration?>(null) }

    LaunchedEffect(Unit) {
        generationTime = measureTime {
            rsaKey = Dispatchers.Default {
                KeyGenerator.generate(
                    algorithm = KeyAlgorithm.RSA,
                    identifier = "dev.sdkforge.crypto.app.rsa",
                    keySize = 512,
                )
            }
        }
    }

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.CenterVertically,
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Generation duration: $generationTime")
            HorizontalDivider()
            Text(text = "RSA private key algorithm: ${rsaKey?.privateKey?.algorithm}")
            Text(text = "RSA private key encoded: ${rsaKey?.privateKey?.encoded?.contentToString()}")
            Text(text = "RSA private key encoded size: ${rsaKey?.privateKey?.encoded?.size}")
            HorizontalDivider()
            Text(text = "RSA public key algorithm: ${rsaKey?.publicKey?.algorithm}")
            Text(text = "RSA public key encoded: ${rsaKey?.publicKey?.encoded?.contentToString()}")
            Text(text = "RSA public key encoded size: ${rsaKey?.publicKey?.encoded?.size}")
        }
    }
}
