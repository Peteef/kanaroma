package io.peteef.kanaroma.strategy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RomajiToHiraganaConverterTest {
    private val converter: RomajiToHiraganaConverter = RomajiToHiraganaConverter

    @Test
    fun itShouldConvertDoubleConsonant() {
        val result = converter.convert("kippu")
        assertEquals("きっぷ", result)
    }

    @Test
    fun itShouldOmitSpace() {
        val result = converter.convert("atarashii kuruma")
        assertEquals("あたらしいくるま", result)
    }

    @Test
    fun itShouldConvertComa() {
        val result = converter.convert("demo, kawaiine")
        assertEquals("でも、かわいいね", result)
    }

    @Test
    fun itShouldConvertDot() {
        val result = converter.convert("hajimemashite.")
        assertEquals("はじめまして。", result)
    }

    @Test
    fun itShouldConvertQuestionMark() {
        val result = converter.convert("daijyobu?")
        assertEquals("だいじょぶ？", result)
    }

    @Test
    fun itShouldConvertExclamationMark() {
        val result = converter.convert("wakatteiruyo!")
        assertEquals("わかっているよ！", result)
    }

    @Test
    fun itShouldConvertParenthesis() {
        val result = converter.convert("watashi(boku)")
        assertEquals("わたし（ぼく）", result)
    }

    @Test
    fun itShouldConvertQuotation() {
        val result = converter.convert("\"kitanai\"toitteita")
        assertEquals("「きたない」といっていた", result)
    }

    @Test
    fun itShouldConvertNumbers() {
        val result = converter.convert("1234567890en")
        assertEquals("1234567890えん", result)
    }
}