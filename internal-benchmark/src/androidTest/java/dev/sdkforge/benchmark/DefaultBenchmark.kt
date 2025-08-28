package dev.sdkforge.benchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import dev.sdkforge.crypto.domain.KeyAlgorithm
import dev.sdkforge.crypto.domain.KeyGenerator
import kotlin.random.Random
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DefaultBenchmark {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun measureRSA4096generation() {
        benchmarkRule.measureRepeated {
            runBlocking {
                KeyGenerator.generate(
                    algorithm = KeyAlgorithm.RSA,
                    identifier = "dev.sdkforge.crypto.app.rsa.${Random.nextInt()}",
                    keySize = 4096,
                )
            }
        }
    }
}
