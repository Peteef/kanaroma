package io.peteef.kanaroma

import io.peteef.kanaroma.conversion.ConversionType.*
import io.peteef.kanaroma.strategy.ConversionStrategies

class Converter(private val capitalizeKatakana: Boolean) {
    private val strategies: ConversionStrategies = ConversionStrategies

    fun toRomaji(kana: String): String {
        val strategy = strategies.get(KANA_TO_ROMAJI)
        TODO("Implement method")
    }

    fun toHiragana(romaji: String): String {
        val strategy = strategies.get(ROMAJI_TO_HIRAGANA)
        TODO("Implement method")
    }

    fun toKatakana(romaji: String): String {
        val strategy = strategies.get(ROMAJI_TO_KATAKANA)
        TODO("Implement method")
    }
}