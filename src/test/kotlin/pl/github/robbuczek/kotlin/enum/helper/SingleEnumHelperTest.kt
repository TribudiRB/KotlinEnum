package pl.github.robbuczek.kotlin.enum.helper

import org.junit.jupiter.api.Test
import pl.github.robbuczek.kotlin.enum.helper.core.single
import pl.github.robbuczek.kotlin.enum.helper.domain.DuplicatedKeyEnum
import pl.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum
import pl.github.robbuczek.kotlin.enum.helper.domain.StringKeyEnum.A
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * Unit tests for [pl.github.robbuczek.kotlin.enum.helper.core.single].
 */
internal class SingleEnumHelperTest {

    @Test
    fun `should find when key exist`() {
        // Given

        // When
        val enum = StringKeyEnum::class.single("a")

        // Then
        assertEquals(expected = A, actual = enum)
    }

    @Test
    fun `should throw exception when unexpected value`() {
        // Given
        // When
        // Then
        assertFailsWith<NoSuchElementException>("Array contains no element matching the predicate.") {
            StringKeyEnum::class single {
                "unexpected"
            }
        }
    }

    @Test
    fun `should throw exception when double keys value`() {
        // Given
        // When
        // Then
        assertFailsWith<NoSuchElementException>("Array contains no element matching the predicate.") {
            DuplicatedKeyEnum::class.single(
                "unexpected"
            )
        }
    }

}