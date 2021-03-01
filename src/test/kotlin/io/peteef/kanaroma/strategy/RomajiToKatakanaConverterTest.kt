package io.peteef.kanaroma.strategy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

internal class RomajiToKatakanaConverterTest {
    private val converter: RomajiToKatakanaConverter = RomajiToKatakanaConverter

    @ParameterizedTest
    @CsvFileSource(resources = ["/data/romaji_to_katakana.csv"], delimiter = ';')
    fun itShouldConvertToHiragana(romaji: String, katakana: String) {
        val result = converter.convert(romaji)
        assertEquals(katakana, result)
    }
}