@file:Suppress("NonAsciiCharacters")
@file:kotlin.jvm.JvmName("EnumHelperAnyOrDefaultExtensionKt")

package com.github.robbuczek.kotlin.enum.helper.core

import com.github.robbuczek.kotlin.enum.helper.EnumHelper
import com.github.robbuczek.kotlin.enum.helper.utils.enum
import kotlin.reflect.KClass

/**
 * Returns the value of [TYPE] which is corresponding to the [keys], or [default] when empty.
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.anyOrDefault(CollectionOf(something), Enum.DEFAULT_ENUM )
 * ```
 *
 * @param TYPE source.
 * @param keys requested elements.
 * @param default when empty.
 */
inline fun <KEY, reified TYPE> KClass<TYPE>.anyOrDefault(
    keys: Collection<KEY>,
    default: TYPE
): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { anyOrDefault(enum, keys, default) }

/**
 * Returns the value of [TYPE] which is corresponding to the [keys], or [default] when empty.
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.anyOrDefault(CollectionOf(something), Enum.DEFAULT_ENUM )
 * ```
 *
 * @param TYPE source.
 * @param keys requested elements.
 * @param default when empty.
 */
inline fun <KEY, reified TYPE> KClass<TYPE>.anyOrDefault(
    vararg keys: KEY,
    default: TYPE
): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { anyOrDefault(enum, keys.toList(), default) }