package io.peteef.kanaroma

import io.peteef.kanaroma.conversion.ConversionType

@JvmSynthetic
internal infix fun IllegalArgumentException.loadTableFailedFor(type: ConversionType): IllegalArgumentException {
    return IllegalArgumentException("Could not load table for type: $type. ${this.message}")
}

@JvmSynthetic
internal infix fun IllegalArgumentException.strategyNotFoundFor(type: ConversionType): IllegalArgumentException {
    return IllegalArgumentException("Could not find strategy for type: $type. ${this.message}")
}