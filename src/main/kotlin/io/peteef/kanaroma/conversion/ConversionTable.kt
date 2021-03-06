package io.peteef.kanaroma.conversion

import io.peteef.kanaroma.csvLines
import io.peteef.kanaroma.loadTableFailedFor
import io.peteef.kanaroma.resourceStream
import java.io.FileNotFoundException

internal class ConversionTable(private val conversionType: ConversionType) {
    companion object {
        private val SPECIAL_CHARACTERS = mapOf(
            "\\s" to " ",
            "\\c" to ", ",
            "," to "\\c"
        )
    }

    private val table: Map<String, String> = load()

    fun get(key: String): String = table[key].orEmpty()

    private fun load(): Map<String, String> {
        try {
            val lines = csvLines(resourceStream("/tables/${conversionType.resourcePath}"))
            return lines.map { it.split(',') }
                .associate { checkForSpecialCharacters(it[0]) to checkForSpecialCharacters(it[1]) }
        } catch (e: FileNotFoundException) {
            throw IllegalArgumentException() loadTableFailedFor conversionType
        }
    }

    private fun checkForSpecialCharacters(str: String): String = SPECIAL_CHARACTERS.getOrDefault(str, str)
}