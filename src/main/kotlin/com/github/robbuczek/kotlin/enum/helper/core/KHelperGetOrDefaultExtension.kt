@file:Suppress("NonAsciiCharacters")
@file:kotlin.jvm.JvmName("EnumHelperGetOrDefaultExtensionKt")

package com.github.robbuczek.kotlin.enum.helper.core

import com.github.robbuczek.kotlin.enum.helper.EnumHelper
import com.github.robbuczek.kotlin.enum.helper.utils.Supplier
import com.github.robbuczek.kotlin.enum.helper.utils.enum
import kotlin.reflect.KClass

/**
 * Returns the list of [TYPE] of the specified collection [keys], or [default] when result is empty.
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.getOrDefault(listOf("MAPPED_ID"), Enum.DEFAULT_ENUM)
 * ```
 *
 * @param TYPE source
 * @param keys requested elements
 * @param default the value when empty.
 */
inline fun <KEY, reified TYPE> KClass<TYPE>.getOrDefault(
    keys: Collection<KEY>,
    default: TYPE
): List<TYPE> where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { getOrDefault(enum, keys, default) }

/**
 * Returns the list of [TYPE] of the specified collection [keys], or [default] when result is empty.
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.getOrDefault(listOf("MAPPED_ID"), listOf(Enum.DEFAULT_ENUM))
 * ```
 *
 * @param TYPE source
 * @param keys requested elements
 * @param default the default collection when result is empty.
 */
inline fun <KEY, reified TYPE> KClass<TYPE>.getOrDefault(
    keys: Collection<KEY>,
    default: List<TYPE>
): List<TYPE> where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { getOrDefault(enum, keys, default) }

/**
 * Returns the value of [TYPE] to which the specified [key] is mapped, or [default] if this value not exist in this [TYPE].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.getOrDefault("MAPPED_ID", Enum.DEFAULT_ENUM)
 * ```
 *
 * @param TYPE source
 * @param key requested element
 * @param default the default collection when result is empty.
 */
inline fun <KEY, reified TYPE> KClass<TYPE>.getOrDefault(
    key: KEY,
    default: TYPE
): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { getOrDefault(enum, key, default) }

/**
 * Returns the value of [TYPE] to which the specified [λ] is mapped, or [default] if this value not exist in this [TYPE].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.getOrDefault(Enum.DEFAULT_ENUM) { "MAPPED_ID" }
 * ```
 *
 * @param TYPE source
 * @param λ requested element
 * @param default the default collection when result is empty.
 */
inline fun <KEY, reified TYPE> KClass<TYPE>.getOrDefault(
    λ: Supplier<KEY>,
    default: TYPE
): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { getOrDefault(enum, λ(), default) }

/**
 * Returns the value of [TYPE] to which the specified [key] is mapped, or [λ] if this value not exist in this [TYPE].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.getOrDefault("MAPPED_ID") { Enum.DEFAULT_ENUM }
 * ```
 *
 * @param TYPE source
 * @param λ requested element
 */
inline fun <KEY, reified TYPE> KClass<TYPE>.getOrDefault(
    key: KEY,
    λ: Supplier<TYPE>
): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { getOrDefault(enum, key, λ()) }