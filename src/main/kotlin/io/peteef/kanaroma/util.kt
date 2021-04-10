package io.peteef.kanaroma

import java.io.File
import java.io.InputStream

@JvmSynthetic
internal fun resourceStream(relativePath: String): InputStream = Converter::class.java.getResourceAsStream(relativePath) ?: File(relativePath).inputStream()

@JvmSynthetic
internal fun csvLines(inputStream: InputStream): List<String> = inputStream.bufferedReader().readLines()

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