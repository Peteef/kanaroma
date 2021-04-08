package io.peteef.kanaroma.strategy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RomajiToKatakanaConverterTest {
    private val converter: RomajiToKatakanaConverter = RomajiToKatakanaConverter

    @Test
    fun itShouldConvertDoubleConsonant() {
        val result = converter.convert("kissu")
        assertEquals("キッス", result)
    }

    @Test
    fun itShouldConvertDoubleVowel() {
        val result = converter.convert("koohii")
        assertEquals("コーヒー", result)
    }

    @Test
    fun itShouldOmitSpace() {
        val result = converter.convert("naisu kissu")
        assertEquals("ナイスキッス", result)
    }

    @Test
    fun itShouldConvertComa() {
        val result = converter.convert("kurasu, tesuto")
        assertEquals("クラス、テスト", result)
    }

    @Test
    fun itShouldConvertDot() {
        val result = converter.convert("baibai.")
        assertEquals("バイバイ。", result)
    }

    @Test
    fun itShouldConvertQuestionMark() {
        val result = converter.convert("terebi?")
        assertEquals("テレビ？", result)
    }

    @Test
    fun itShouldConvertExclamationMark() {
        val result = converter.convert("okke!")
        assertEquals("オッケ！", result)
    }

    @Test
    fun itShouldConvertParenthesis() {
        val result = converter.convert("zero(0)")
        assertEquals("ゼロ（0）", result)
    }

    @Test
    fun itShouldConvertQuotation() {
        val result = converter.convert("\"apaato\"hoteru")
        assertEquals("「アパート」ホテル", result)
    }

    @Test
    fun itShouldConvertNumbers() {
        val result = converter.convert("1234567890sentimeetoru")
        assertEquals("1234567890センチメートル", result)
    }
}