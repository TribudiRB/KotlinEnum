package pl.github.robbuczek.kotlin.enum.helper.domain

import pl.github.robbuczek.kotlin.enum.helper.EnumHelper

/**
 * Simple test domain.
 */
internal enum class MultiValueKeyEnum(override val key: Pair<String, String>) :
    EnumHelper<Pair<String, String>> {

    A("a" to "A"),
    B("b" to "B"),
    C("c" to "C")

}