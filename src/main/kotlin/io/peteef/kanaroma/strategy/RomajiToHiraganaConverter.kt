package io.peteef.kanaroma.strategy

import io.peteef.kanaroma.Quotation
import io.peteef.kanaroma.conversion.ConversionTable
import io.peteef.kanaroma.conversion.ConversionType.ROMAJI_TO_HIRAGANA

internal object RomajiToHiraganaConverter: Converting {
    private val table: ConversionTable = ConversionTable(ROMAJI_TO_HIRAGANA)

    override fun convert(text: String): String {
        val sb = StringBuilder()
        val quotation = Quotation()

        var i = 0
        while (i < text.length) {
            //Omit spaces
            if(isSpace(text, i)) {
                i += 1
                continue
            }

            //"Intelligent" quotations
            if(isQuotation(text, i)) {
                sb.append(quotation.get())
                i += 1
                continue
            }

            //3-char substring
            val three = check(text, i, 3)
            if(three.isNotBlank()) {
                sb.append(three)
                i += 3
                continue
            }

            //2-char substring
            val two = check(text, i, 2)
            if(two.isNotBlank()) {
                sb.append(two)
                i += 2
                continue
            }

            //1-char substring
            val one = check(text, i, 1)
            if(one.isNotBlank()) {
                sb.append(one)
                i += 1
                continue
            }

            //Double consonant
            sb.append('っ')
            i += 1
        }

        return sb.toString()
    }

    private fun isSpace(text: String, i: Int): Boolean = text[i].isWhitespace()

    private fun isQuotation(text: String, i: Int): Boolean = text[i] == '"'

    private fun check(text: String, i: Int, n: Int): String {
        if(i + n > text.length) {
            return ""
        }

        val toBeChecked = text.substring(i until i + n)
        return table.get(toBeChecked)
    }
}