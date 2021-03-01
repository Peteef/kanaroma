package io.peteef.kanaroma.strategy

import io.peteef.kanaroma.conversion.ConversionTable
import io.peteef.kanaroma.conversion.ConversionType.ROMAJI_TO_HIRAGANA

object RomajiToHiraganaConverter: Converting {
    private val table: ConversionTable = ConversionTable(ROMAJI_TO_HIRAGANA)
    override fun convert(text: String): String {
        TODO("Not yet implemented")
    }
}