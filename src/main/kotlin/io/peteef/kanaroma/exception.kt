package io.peteef.kanaroma

import io.peteef.kanaroma.conversion.ConversionType

internal fun IllegalArgumentException.loadTableFailed(type: ConversionType): IllegalArgumentException {
    return IllegalArgumentException("Could not load table for type: $type")
}

internal fun IllegalArgumentException.tableNotFound(type: ConversionType): IllegalArgumentException {
    return IllegalArgumentException("Could not find table for type: $type")
}

internal fun IllegalArgumentException.strategyNotFound(type: ConversionType): IllegalArgumentException {
    return IllegalArgumentException("Could not find strategy for type: $type")
}