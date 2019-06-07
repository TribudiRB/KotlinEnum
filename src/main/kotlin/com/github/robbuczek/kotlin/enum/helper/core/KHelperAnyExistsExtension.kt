@file:Suppress("NonAsciiCharacters")
@file:kotlin.jvm.JvmName("EnumHelperExtensionKt")

package com.github.robbuczek.kotlin.enum.helper.core

import com.github.robbuczek.kotlin.enum.helper.EnumHelper
import com.github.robbuczek.kotlin.enum.helper.utils.Supplier
import com.github.robbuczek.kotlin.enum.helper.utils.enum
import kotlin.reflect.KClass

/**
 * Returns `true` when [TYPE] contains one or more [keys].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.anyExists(CollectionOf(something))
 *
 *  or
 *
 *  EnumClass::class anyExists CollectionOf(something)
 * ```
 *
 * @param TYPE source
 * @param keys requested elements
 */
inline infix fun <KEY, reified TYPE> KClass<TYPE>.anyExists(keys: Collection<KEY>): Boolean where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { anyExists(enum, keys) }

/**
 * Returns `true` when [TYPE] contains one or more [keys].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.anyExists("x","y","z")
 * ```
 *
 * @param TYPE source
 * @param keys requested elements
 */
inline fun <KEY, reified TYPE> KClass<TYPE>.anyExists(vararg keys: KEY): Boolean where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { anyExists(enum, keys.toList()) }

/**
 * Returns `true` when [TYPE] contains one or more of [λ].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.anyExists { CollectionOf(something) }
 *
 *  or
 *
 *  EnumClass::class anyExists { CollectionOf(something) }
 * ```
 *
 * @param TYPE source
 * @param λ requested elements
 */
inline infix fun <KEY, reified TYPE> KClass<TYPE>.anyExists(λ: Supplier<Collection<KEY>>): Boolean where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { anyExists(enum, λ()) }
