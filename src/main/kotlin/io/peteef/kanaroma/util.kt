package io.peteef.kanaroma

import java.io.BufferedReader
import java.io.FileReader

internal fun resourcePath(relativePath: String): String = Converter::class.java.getResource(relativePath)?.path ?: relativePath

internal fun csvLines(path: String): List<String> = BufferedReader(FileReader(path)).readLines()

internal class Quotation {
    private companion object {
        private const val START = "「"
        private const val FINISH = "」"
    }

    private var isStart: Boolean = false

    fun get(): String {
        isStart = !isStart
        return if (isStart) START else FINISH
    }
}