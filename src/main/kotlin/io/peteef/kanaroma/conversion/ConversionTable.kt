package io.peteef.kanaroma.conversion

import io.peteef.kanaroma.csvLines

class ConversionTable(private val conversionType: ConversionType) {
    private val table: Map<String, String> = load()

    fun get(key: String): String = table[key].orEmpty()

    private fun load(): Map<String, String> {
        val lines = csvLines(conversionType.resourcePath)
        return lines.map { it.split(',') }
            .map { it[0] to it[1] }
            .toMap()
    }
}