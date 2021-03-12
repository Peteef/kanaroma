package io.peteef.kanaroma

import io.peteef.kanaroma.conversion.ConversionType.*
import io.peteef.kanaroma.strategy.ConversionStrategies

class Converter(private val capitalizeKatakana: Boolean) {
    private val strategies: ConversionStrategies = ConversionStrategies

    fun toRomaji(kana: String): String {
        val strategy = strategies.get(KANA_TO_ROMAJI)
        return strategy.convert(kana)
    }

    fun toHiragana(romaji: String): String {
        val strategy = strategies.get(ROMAJI_TO_HIRAGANA)
        return strategy.convert(romaji)
    }

    fun toKatakana(romaji: String): String {
        val strategy = strategies.get(ROMAJI_TO_KATAKANA)
        return strategy.convert(romaji)
    }
}