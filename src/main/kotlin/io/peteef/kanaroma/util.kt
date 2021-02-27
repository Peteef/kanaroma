package io.peteef.kanaroma

import java.io.BufferedReader
import java.io.FileReader

fun csvLines(path: String): List<String> = BufferedReader(FileReader(path)).readLines()