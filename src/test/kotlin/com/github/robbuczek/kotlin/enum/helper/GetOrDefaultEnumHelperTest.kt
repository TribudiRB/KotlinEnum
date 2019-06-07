package com.github.robbuczek.kotlin.enum.helper

import org.junit.jupiter.api.Test
import com.github.robbuczek.kotlin.enum.helper.core.getOrDefault
import com.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum
import com.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum.A
import com.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum.B
import com.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum.C
import kotlin.test.assertEquals

/**
 * Unit tests for [com.github.robbuczek.kotlin.enum.helper.core.getOrDefault].
 */
internal class GetOrDefaultEnumHelperTest {

    @Test
    fun `should find when key exist`() {
        // Given

        // When
        val enum = StringKeyEnum::class.getOrDefault(key = "a", default = C)

        // Then
        assertEquals(expected = A, actual = enum)
    }

    @Test
    fun `should return default value when could not find enum`() {
        // Given

        // When
        val enum = StringKeyEnum::class.getOrDefault("unexpected", A)

        // Then
        assertEquals(expected = A, actual = enum)
    }

    @Test
    fun `should find when provided list of values`() {
        // Given
        val expected = listOf(A, B)

        // When
        val enum = StringKeyEnum::class.getOrDefault(expected.map { it.key }, listOf())

        // Then
        assertEquals(expected, actual = enum)
    }

    @Test
    fun `should to find only existing values`() {
        // Given
        val expected = listOf("a", "C", "x", "y", "z")

        // When
        val enum = StringKeyEnum::class.getOrDefault(expected, listOf())

        // Then
        assertEquals(expected = listOf(A), actual = enum)
    }

    @Test
    fun `should return default collection of elements`() {
        // Given
        val expected = listOf(A, B)

        // When
        val enum = StringKeyEnum::class.getOrDefault(listOf("x", "y", "z"), expected)

        // Then
        assertEquals(expected, actual = enum)
    }

    @Test
    fun `should return default collection of elements by provided single element`() {
        // Given
        val expected = listOf(A)

        // When
        val enum = StringKeyEnum::class.getOrDefault(listOf("x", "y", "z"), A)

        // Then
        assertEquals(expected, actual = enum)
    }

}