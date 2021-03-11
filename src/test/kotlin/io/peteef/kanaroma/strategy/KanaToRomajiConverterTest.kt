package io.peteef.kanaroma.strategy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

internal class KanaToRomajiConverterTest {
    private val converter: KanaToRomajiConverter = KanaToRomajiConverter

    @ParameterizedTest
    @CsvFileSource(resources = ["/data/kana_to_romaji.csv"], delimiter = ';')
    fun itShouldConvertToHiragana(kana: String, romaji: String) {
        val result = converter.convert(kana)
        assertEquals(romaji, result)
    }
}