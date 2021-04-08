package io.peteef.kanaroma.benchmark

import io.peteef.kanaroma.Converter
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.FileReader
import kotlin.system.measureTimeMillis

internal class BenchmarkTest {
    private val converter: Converter = Converter()

    @Nested
    inner class KanaToRomaji {
        @Test
        fun singleCharacters() {
            val characters = loadCharacters("/benchmark/kana_romaji_characters.dat")
            val average = benchmark(characters, converter::toRomaji)
            println("Average for ${characters.size} characters: $average ms")
        }
    }

    @Nested
    inner class RomajiToHiragana {
        @Test
        fun singleCharacters() {
            val characters = loadCharacters("/benchmark/romaji_hiragana_characters.dat")
            val average = benchmark(characters, converter::toHiragana)
            println("Average for ${characters.size} characters: $average ms")
        }
    }

    @Nested
    inner class RomajiToKatakana {
        @Test
        fun singleCharacters() {
            val characters = loadCharacters("/benchmark/romaji_katakana_characters.dat")
            val average = benchmark(characters, converter::toKatakana)
            println("Average for ${characters.size} characters: $average ms")
        }
    }

    internal fun loadCharacters(filepath: String): List<String> {
        return BufferedReader(
            FileReader(BenchmarkTest::class.java.getResource(filepath)?.path ?: filepath)
        ).readLines()
    }

    internal fun benchmark(input: List<String>, operation: (String) -> String): Double {
        return input.shuffled().map { measure { operation(it) } }.average()
    }

    private fun measure(operation: () -> Unit): Long {
        return measureTimeMillis(operation)
    }
}
