package io.peteef.kanaroma.conversion

import io.peteef.kanaroma.csvLines
import io.peteef.kanaroma.loadTableFailed
import io.peteef.kanaroma.resourcePath
import java.io.FileNotFoundException

class ConversionTable(private val conversionType: ConversionType) {
    private val table: Map<String, String> = load()

    fun get(key: String): String = table[key].orEmpty()

    private fun load(): Map<String, String> {
        try {
            val lines = csvLines(resourcePath("/tables/${conversionType.resourcePath}"))
            return lines.map { it.split(',') }
                .map { it[0] to it[1] }
                .toMap()
        } catch (e: FileNotFoundException) {
            throw IllegalArgumentException().loadTableFailed(conversionType)
        }
    }
}