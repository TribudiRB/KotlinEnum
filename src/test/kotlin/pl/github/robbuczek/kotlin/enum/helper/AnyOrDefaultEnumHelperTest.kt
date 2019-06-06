package pl.github.robbuczek.kotlin.enum.helper

import org.junit.jupiter.api.Test
import pl.github.robbuczek.kotlin.enum.helper.core.anyOrDefault
import pl.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum
import pl.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum.A
import kotlin.test.assertEquals

/**
 * Unit tests for [pl.github.robbuczek.kotlin.enum.helper.core.anyOrDefault].
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
