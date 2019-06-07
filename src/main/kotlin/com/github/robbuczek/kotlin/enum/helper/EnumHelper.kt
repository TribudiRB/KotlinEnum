package com.github.robbuczek.kotlin.enum.helper

import com.github.robbuczek.kotlin.enum.helper.core.Embedded

interface EnumHelper<out KEY> {
    val key: KEY

    companion object : Embedded()
}