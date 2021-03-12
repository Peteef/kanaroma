package io.peteef.kanaroma.strategy

import io.peteef.kanaroma.conversion.ConversionType
import io.peteef.kanaroma.conversion.ConversionType.*
import io.peteef.kanaroma.strategyNotFound

internal object ConversionStrategies {
    private val tables: Map<ConversionType, Converting> = mapOf(
        KANA_TO_ROMAJI to KanaToRomajiConverter,
        ROMAJI_TO_HIRAGANA to RomajiToHiraganaConverter,
        ROMAJI_TO_KATAKANA to RomajiToKatakanaConverter
    )

    fun get(type: ConversionType): Converting {
        return tables[type] ?: throw IllegalArgumentException().strategyNotFound(type)
    }
}