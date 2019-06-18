package com.github.tribudirb.kotlin.enum.helper

import com.github.tribudirb.kotlin.enum.helper.core.Embedded

/**
 * Marker which will provide additional logic.
 */
interface EnumHelper<out KEY> {

    /**
     * Index key.
     */
    val key: KEY

    /**
     * Additional logic assigned to every implementation.
     */
    companion object : Embedded()
}