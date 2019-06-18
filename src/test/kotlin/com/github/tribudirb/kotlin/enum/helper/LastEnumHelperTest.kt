package com.github.tribudirb.kotlin.enum.helper

import org.junit.jupiter.api.Test
import com.github.tribudirb.kotlin.enum.helper.core.last
import com.github.tribudirb.kotlin.enum.helper.domain.DuplicatedKeyEnum
import com.github.tribudirb.kotlin.enum.helper.domain.StringKeyEnum
import com.github.tribudirb.kotlin.enum.helper.domain.StringKeyEnum.A
import com.github.tribudirb.kotlin.enum.helper.domain.StringKeyEnum.B
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * Unit tests for [com.github.tribudirb.kotlin.enum.helper.core.last].
 */
internal class LastEnumHelperTest {

    @Test
    fun `should find last when request elements`() {
        // Given

        // When
        val enum = StringKeyEnum::class last { listOf("a", "b", "tmp") }

        // Then
        assertEquals(expected = B, actual = enum)
    }

    @Test
    fun `should find last when key exist`() {
        // Given

        // When
        val enum = StringKeyEnum::class.last(listOf("a", "b", "tmp"))

        // Then
        assertEquals(expected = B, actual = enum)
    }

    @Test
    fun `should throw exception when can not find`() {
        // Given
        // When
        // Then
        assertFailsWith<NoSuchElementException>("Array contains no element matching the predicate.") {
            DuplicatedKeyEnum::class.last(
                "unexpected"
            )
        }
    }

    @Test
    fun `should find last when provided directly`() {
        // Given

        // When
        val enum = StringKeyEnum::class.last("x", "w", "B", "a", "tmp")

        // Then
        assertEquals(expected = A, actual = enum)
    }

}