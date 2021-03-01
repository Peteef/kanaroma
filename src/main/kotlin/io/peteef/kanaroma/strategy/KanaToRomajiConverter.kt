package io.peteef.kanaroma.strategy

import io.peteef.kanaroma.conversion.ConversionTable
import io.peteef.kanaroma.conversion.ConversionType.KANA_TO_ROMAJI

object KanaToRomajiConverter: Converting {
    private val table: ConversionTable = ConversionTable(KANA_TO_ROMAJI)

    override fun convert(text: String): String {
        TODO("Not yet implemented")
    }
}