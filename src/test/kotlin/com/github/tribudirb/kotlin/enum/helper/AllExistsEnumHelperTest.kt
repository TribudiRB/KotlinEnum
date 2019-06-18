package com.github.tribudirb.kotlin.enum.helper

import org.junit.jupiter.api.Test
import com.github.tribudirb.kotlin.enum.helper.core.allExists
import com.github.tribudirb.kotlin.enum.helper.domain.StringKeyEnum
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Unit tests for [com.github.tribudirb.kotlin.enum.helper.core.allExists].
 */
internal class AllExistsEnumHelperTest {

    @Test
    fun `all of requested values should be enums`() {
        // Given
        val elements = listOf("a", "b")

        // When
        val enum = StringKeyEnum::class allExists { elements }

        // Then
        assertTrue { enum }
    }

    @Test
    fun `one of requested should not be an enum`() {
        // Given
        val elements = listOf("x", "a", "b")

        // When
        val enum = StringKeyEnum::class allExists elements

        // Then
        assertFalse { enum }
    }

    @Test
    fun `should return false when one of the elements does not exist in enum`() {
        // Given

        // When
        val enum = StringKeyEnum::class.allExists("x", "w", "B", "tmp")

        // Then
        assertFalse { enum }
    }

}