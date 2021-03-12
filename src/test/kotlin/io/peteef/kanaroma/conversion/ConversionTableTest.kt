package io.peteef.kanaroma.conversion

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockkObject
import io.peteef.kanaroma.conversion.ConversionType.KANA_TO_ROMAJI
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ConversionTableTest {
    @AfterEach
    internal fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun itShouldLoadFile() {
        mockResource()
        assertDoesNotThrow {
            ConversionTable(KANA_TO_ROMAJI)
        }
    }

    @Test
    fun itShouldThrowWhenNotLoadFile() {
        mockResource(path = "not_existing.csv")
        assertThrows(IllegalArgumentException::class.java) {
            ConversionTable(KANA_TO_ROMAJI)
        }
    }

    @Test
    fun itShouldReturnConversion() {
        mockResource()
        val table = ConversionTable(KANA_TO_ROMAJI)
        val result = table.get("あ")
        assertEquals("a", result)
    }

    @Test
    fun itShouldReturnEmptyStringWhenThereIsNoConversion() {
        mockResource()
        val table = ConversionTable(KANA_TO_ROMAJI)
        val result = table.get("か")
        assertEquals("", result)
    }

    private fun mockResource(type: ConversionType = KANA_TO_ROMAJI, path: String = "test.csv") {
        mockkObject(type)
        every { type.resourcePath } returns path
    }
}