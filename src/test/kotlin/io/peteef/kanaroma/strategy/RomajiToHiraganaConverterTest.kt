package io.peteef.kanaroma.strategy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

internal class RomajiToHiraganaConverterTest {
    private val converter: RomajiToHiraganaConverter = RomajiToHiraganaConverter

    @ParameterizedTest
    @CsvFileSource(resources = ["/data/romaji_to_hiragana.csv"], delimiter = ';')
    fun itShouldConvertToHiragana(romaji: String, hiragana: String) {
        val result = converter.convert(romaji)
        assertEquals(hiragana, result)
    }
}