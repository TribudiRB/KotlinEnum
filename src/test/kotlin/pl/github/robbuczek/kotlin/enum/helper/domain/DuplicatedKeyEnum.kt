package pl.github.robbuczek.kotlin.enum.helper.domain

import pl.github.robbuczek.kotlin.enum.helper.EnumHelper

/**
 * Simple test domain.
 */
internal enum class DuplicatedKeyEnum(override val key: String) :
    EnumHelper<String> {

    A("a"),
    B("b"),
    C("a")

}