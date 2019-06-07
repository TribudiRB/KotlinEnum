package com.github.robbuczek.kotlin.enum.helper

import org.junit.jupiter.api.Test
import com.github.robbuczek.kotlin.enum.helper.core.anyOrDefault
import com.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum
import com.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum.A
import kotlin.test.assertEquals

/**
 * Unit tests for [com.github.robbuczek.kotlin.enum.helper.core.anyOrDefault].
 */
internal class AnyOrDefaultEnumHelperTest {

    @Test
    fun `should find first when key exist`() {
        // Given
        val elements = listOf("a", "b", "d")

        // When
        val enum = StringKeyEnum::class.anyOrDefault(elements, A)

        // Then
        assertEquals(expected = A, actual = enum)
    }

    @Test
    fun `should return default when could not find`() {
        // Given
        val elements = listOf("x", "y", "z")

        // When
        val enum = StringKeyEnum::class.anyOrDefault(elements, A)

        // Then
        assertEquals(expected = A, actual = enum)
    }

}
