@file:kotlin.jvm.JvmName("TypeAliasesKt")

package pl.github.robbuczek.kotlin.enum.helper.utils

/**
 * [EnumClass] means the `Class<Enum<*>>` type we're defining this as a simple abbreviation.
 */
typealias EnumClass = Class<Enum<*>>

/**
* [Supplier] means the `() -> TYPE` e.g function which going to provide expected type we're defining this as a simple abbreviation.
*/
typealias Supplier<TYPE> = () -> TYPE