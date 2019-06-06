package pl.github.robbuczek.kotlin.enum.helper

import org.junit.jupiter.api.Test
import pl.github.robbuczek.kotlin.enum.helper.core.first
import pl.github.robbuczek.kotlin.enum.helper.domain.DuplicatedKeyEnum
import pl.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum
import pl.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum.A
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * Unit tests for [pl.github.robbuczek.kotlin.enum.helper.core.first].
 */
internal class FirstEnumHelperTest {

    @Test
    fun `should find first when key exist`() {
        // Given

        // When
        val enum = StringKeyEnum::class.first {
            listOf("a", "b", "tmp")
        }

        // Then
        assertEquals(expected = A, actual = enum)
    }

    @Test
    fun `should throw exception when can not find`() {
        // Given
        // When
        // Then
        assertFailsWith<NoSuchElementException>("Array contains no element matching the predicate.") {
            DuplicatedKeyEnum::class.first(
                "unexpected"
            )
        }
    }

    @Test
    fun `should find first when provided directly`() {
        // Given

        // When
        val enum = StringKeyEnum::class.first("x", "w", "B", "a", "tmp")

        // Then
        assertEquals(expected = A, actual = enum)
    }

}