package pl.github.robbuczek.kotlin.enum.helper

import org.junit.jupiter.api.Test
import pl.github.robbuczek.kotlin.enum.helper.core.anyExists
import pl.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Unit tests for [pl.github.robbuczek.kotlin.enum.helper.core.anyExists].
 */
internal class AnyExistsEnumHelperTest {

    @Test
    fun `should find first when key exist`() {
        // Given
        val elements = listOf("a", "f", "tmp")

        // When
        val enum = StringKeyEnum::class.anyExists(elements)

        // Then
        assertTrue { enum }
    }

    @Test
    fun `should find first when using varargs key exist`() {
        // Given

        // When
        val enum = StringKeyEnum::class.anyExists("a", "f", "tmp")

        // Then

        assertTrue { enum }
    }

    @Test
    fun `should return default when could not find`() {
        // Given
        val elements = listOf("x", "w", "B", "tmp")

        // When
        val enum = StringKeyEnum::class anyExists elements

        // Then
        assertFalse { enum }
    }

}