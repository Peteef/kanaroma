package io.peteef.kanaroma.strategy

import io.peteef.kanaroma.conversion.ConversionTable
import io.peteef.kanaroma.conversion.ConversionType.KANA_TO_ROMAJI

internal object KanaToRomajiConverter : Converting {
    private val EXCEPTIONAL_CONSONANTS = mapOf(
        'c' to 't'
    )

    private val table: ConversionTable = ConversionTable(KANA_TO_ROMAJI)

    override fun convert(text: String): String {
        val sb = StringBuilder()

        var i = 0
        while (i < text.length) {
            //Double consonant
            val doubleConsonant = checkDoubleConsonant(text, i)
            if (doubleConsonant.isNotBlank()) {
                sb.append(doubleConsonant)
                i += 1
                continue
            }

            //Double vowel
            val doubleVowel = checkDoubleVowel(text, i)
            if (doubleVowel.isNotBlank()) {
                sb.append(doubleVowel)
                i += 1
                continue
            }

            //2-char substring
            val two = check(text, i, 2)
            if (two.isNotBlank()) {
                sb.append(two)
                i += 2
                continue
            }

            //1-char substring
            val one = check(text, i, 1)
            if (one.isNotBlank()) {
                sb.append(one)
                i += 1
                continue
            }

            i += 1
        }

        return sb.toString()
    }

    private fun check(text: String, i: Int, n: Int): String {
        if (i + n > text.length) {
            return ""
        }

        val toBeChecked = text.substring(i until i + n)
        return table.get(toBeChecked)
    }

    private fun checkDoubleConsonant(text: String, i: Int): String {
        if (text[i] == 'っ' || text[i] == 'ッ') {
            val toBeDoubled = check(text, i + 1, 1)
            return if (toBeDoubled.isNotBlank()) checkForExceptionalConsonant(toBeDoubled.first()).toString() else ""
        }

        return ""
    }

    private fun checkDoubleVowel(text: String, i: Int): String {
        if (i > 0 && (text[i] == 'っ' || text[i] == 'ー')) {
            val toBeDoubled = check(text, i - 1, 1)
            return if (toBeDoubled.isNotBlank()) toBeDoubled.last().toString() else ""
        }

        return ""
    }

    private fun checkForExceptionalConsonant(consonant: Char): Char {
        return EXCEPTIONAL_CONSONANTS.getOrDefault(consonant, consonant)
    }
}