package io.peteef.kanaroma.strategy

import io.peteef.kanaroma.conversion.ConversionTable
import io.peteef.kanaroma.conversion.ConversionType.ROMAJI_TO_KATAKANA

object RomajiToKatakanaConverter: Converting {
    private val table: ConversionTable = ConversionTable(ROMAJI_TO_KATAKANA)

    override fun convert(text: String): String {
        TODO("Not yet implemented")
    }
}