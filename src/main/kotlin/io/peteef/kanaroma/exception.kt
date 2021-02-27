package io.peteef.kanaroma

import io.peteef.kanaroma.conversion.ConversionType

fun IllegalArgumentException.loadTableFailed(type: ConversionType): IllegalArgumentException {
    return IllegalArgumentException("Could not load table for type: $type")
}

fun IllegalArgumentException.tableNotFound(type: ConversionType): IllegalArgumentException {
    return IllegalArgumentException("Could not find table for type: $type")
}