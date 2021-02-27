package io.peteef.kanaroma.conversion

import io.peteef.kanaroma.conversion.ConversionType.*
import io.peteef.kanaroma.tableNotFound

object ConversionTables {
    private val tables: Map<ConversionType, ConversionTable> = mapOf(
        KANA_TO_ROMAJI to ConversionTable(KANA_TO_ROMAJI),
        ROMAJI_TO_HIRAGANA to ConversionTable(ROMAJI_TO_HIRAGANA),
        ROMAJI_TO_KATAKANA to ConversionTable(ROMAJI_TO_KATAKANA)
    )

    fun get(type: ConversionType): ConversionTable {
        return tables[type] ?: throw IllegalArgumentException().tableNotFound(type)
    }
}