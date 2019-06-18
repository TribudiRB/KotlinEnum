package com.github.tribudirb.kotlin.enum.helper.domain

import com.github.tribudirb.kotlin.enum.helper.EnumHelper

/**
 * Simple test domain.
 */
internal enum class MultiValueKeyEnum(override val key: Pair<String, String>) : EnumHelper<Pair<String, String>> {

    A("a" to "A"),
    B("b" to "B"),
    C("c" to "C")

}