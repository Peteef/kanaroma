package io.peteef.kanaroma.conversion

internal enum class ConversionType(internal val resourcePath: String) {
    KANA_TO_ROMAJI("kana_romaji.csv"),
    ROMAJI_TO_HIRAGANA("romaji_hiragana.csv"),
    ROMAJI_TO_KATAKANA("romaji_katakana.csv")
}