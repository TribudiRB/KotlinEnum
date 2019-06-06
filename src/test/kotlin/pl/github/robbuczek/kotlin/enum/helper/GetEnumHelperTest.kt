package pl.github.robbuczek.kotlin.enum.helper

import org.junit.jupiter.api.Test
import pl.github.robbuczek.kotlin.enum.helper.core.get
import pl.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum
import pl.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum.A
import pl.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum.B
import kotlin.test.assertEquals

/**
 * Unit tests for [pl.github.robbuczek.kotlin.enum.helper.core.get].
 */
internal class GetEnumHelperTest {

    @Test
    fun `should find when key exists`() {
        // Given

        // When
        val enum = StringKeyEnum::class get "a"

        // Then
        assertEquals(expected = A, actual = enum)
    }

    @Test
    fun `should return null when enum not exists`() {
        // Given

        // When
        val enum = StringKeyEnum::class get "unexpected"

        // Then
        assertEquals(expected = null, actual = enum)
    }

    @Test
    fun `should find when provided list of values`() {
        // Given
        val expected = listOf(A, B)

        // When
        val enum = StringKeyEnum::class.get(expected.map { it.key })

        // Then
        assertEquals(expected, actual = enum)
    }

    @Test
    fun `should to find only existing values`() {
        // Given
        val expected = listOf("a", "C", "x", "y", "z")

        // When
        val enum = StringKeyEnum::class.get(expected)

        // Then
        assertEquals(expected = listOf(A), actual = enum)
    }

}