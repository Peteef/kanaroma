package io.peteef.kanaroma.strategy

import io.peteef.kanaroma.conversion.ConversionTable
import io.peteef.kanaroma.conversion.ConversionType.ROMAJI_TO_KATAKANA

object RomajiToKatakanaConverter: Converting {
    private val table: ConversionTable = ConversionTable(ROMAJI_TO_KATAKANA)

    override fun convert(text: String): String {
        val sb = StringBuilder()
        val preProcessed = replaceMultipleVowels(text)

        var i = 0
        while (i < preProcessed.length) {
            //3-char substring
            val three = check(preProcessed, i, 3)
            if(three.isNotBlank()) {
                sb.append(three)
                i += 3
                continue
            }

            //2-char substring
            val two = check(preProcessed, i, 2)
            if(two.isNotBlank()) {
                sb.append(two)
                i += 2
                continue
            }

            //1-char substring
            val one = check(preProcessed, i, 1)
            if(one.isNotBlank()) {
                sb.append(one)
                i += 1
                continue
            }

            //Double consonant
            sb.append('ッ')
            i += 1
        }

        return sb.toString()
    }

    private fun replaceMultipleVowels(text: String): String {
        return text.replace(Regex("a+a"), "a-")
            .replace(Regex("o+o"), "o-")
            .replace(Regex("e+e"), "e-")
            .replace(Regex("i+i"), "i-")
            .replace(Regex("u+u"), "u-")
    }

    private fun check(text: String, i: Int, n: Int): String {
        if(i + n > text.length) {
            return ""
        }

        val toBeChecked = text.substring(i until i + n)
        return table.get(toBeChecked)
    }
}