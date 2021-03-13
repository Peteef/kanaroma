package io.peteef.kanaroma.strategy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class KanaToRomajiConverterTest {
    private val converter: KanaToRomajiConverter = KanaToRomajiConverter

    @Test
    fun itShouldConvertDoubleConsonant() {
        val hiraganaResult = converter.convert("きっぷ")
        val katakanaResult = converter.convert("キッス")
        assertEquals("kippu", hiraganaResult)
        assertEquals("kissu", katakanaResult)
    }

    @Test
    fun itShouldConvertDoubleVowel() {
        val hiraganaResult = converter.convert("あっ")
        val katakanaResult = converter.convert("コーヒー")
        assertEquals("aa", hiraganaResult)
        assertEquals("koohii", katakanaResult)
    }

    @Test
    fun itShouldConvertSpace() {
        val result = converter.convert("あたらしい　くるま")
        assertEquals("atarashii kuruma", result)
    }

    @Test
    fun itShouldConvertComa() {
        val result = converter.convert("でも、かわいいね")
        assertEquals("demo, kawaiine", result)
    }

    @Test
    fun itShouldConvertDot() {
        val result = converter.convert("はじめまして。")
        assertEquals("hajimemashite.", result)
    }

    @Test
    fun itShouldConvertQuestionMark() {
        val result = converter.convert("だいじょぶ？")
        assertEquals("daijyobu?", result)
    }

    @Test
    fun itShouldConvertExclamationMark() {
        val result = converter.convert("わかっているよ！")
        assertEquals("wakatteiruyo!", result)
    }

    @Test
    fun itShouldConvertParenthesis() {
        val result = converter.convert("わたし（ぼく）")
        assertEquals("watashi(boku)", result)
    }

    @Test
    fun itShouldConvertQuotation() {
        val result = converter.convert("「きたない」といっていた")
        assertEquals("\"kitanai\"toitteita", result)
    }

    @Test
    fun itShouldConvertNumbers() {
        val result = converter.convert("1234567890えん")
        assertEquals("1234567890en", result)
    }
}