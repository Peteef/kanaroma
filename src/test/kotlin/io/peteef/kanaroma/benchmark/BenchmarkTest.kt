package io.peteef.kanaroma.benchmark

import io.peteef.kanaroma.Converter
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.FileReader
import kotlin.system.measureTimeMillis

internal class BenchmarkTest {
    companion object {
        private const val CHAR_THRESHOLD = 0.05
        private const val WORD_THRESHOLD = 0.2
    }

    private val converter: Converter = Converter()

    @Nested
    inner class KanaToRomaji {
        @Test
        fun singleCharacters() {
            testCharacters("/benchmark/kana_romaji_characters.dat", converter::toRomaji)
        }

        @Test
        fun singleWords() {
            testWords("/benchmark/kana_romaji_words.dat", converter::toRomaji)
        }
    }

    @Nested
    inner class RomajiToHiragana {
        @Test
        fun singleCharacters() {
            testCharacters("/benchmark/romaji_hiragana_characters.dat", converter::toHiragana)
        }

        @Test
        fun singleWords() {
            testWords("/benchmark/romaji_hiragana_words.dat", converter::toHiragana)
        }
    }

    @Nested
    inner class RomajiToKatakana {
        @Test
        fun singleCharacters() {
            testCharacters("/benchmark/romaji_katakana_characters.dat", converter::toKatakana)
        }

        @Test
        fun singleWords() {
            testWords("/benchmark/romaji_katakana_words.dat", converter::toKatakana)
        }
    }

    internal fun testCharacters(path: String, operation: (String) -> String) {
        val characters = loadInput(path)
        val average = benchmark(characters, operation)
        println("Average for ${characters.size} characters: $average ms")
        assertTrue(average < CHAR_THRESHOLD)
    }

    internal fun testWords(path: String, operation: (String) -> String) {
        val words = loadInput(path)
        val average = benchmark(words, operation)
        println("Average for ${words.size} words: $average ms")
        assertTrue(average < WORD_THRESHOLD)
    }

    private fun loadInput(filepath: String): List<String> {
        return BufferedReader(
            FileReader(BenchmarkTest::class.java.getResource(filepath)?.path ?: filepath)
        ).readLines()
    }

    private fun benchmark(input: List<String>, operation: (String) -> String): Double {
        return input.shuffled().map { measure { operation(it) } }.average()
    }

    private fun measure(operation: () -> Unit): Long {
        return measureTimeMillis(operation)
    }
}
