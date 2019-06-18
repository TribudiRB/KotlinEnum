@file:Suppress("NonAsciiCharacters")
@file:[JvmName("KHelperExtensionKt") JvmMultifileClass]

package com.github.tribudirb.kotlin.enum.helper.core

import com.github.tribudirb.kotlin.enum.helper.EnumHelper
import com.github.tribudirb.kotlin.enum.helper.utils.Supplier
import com.github.tribudirb.kotlin.enum.helper.utils.enum
import kotlin.reflect.KClass

/**
 * Returns the [TYPE] of the specified [key].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.get("key")
 *
 *  or
 *
 *  EnumClass::class get "key"
 * ```
 *
 * @param key - the key of which the [TYPE] is associated.
 */
inline infix fun <KEY, reified TYPE> KClass<TYPE>.get(key: KEY): TYPE? where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { get(enum, key) }

/**
 * Returns the [TYPE] of the specified [λ].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.get { "key" }
 *
 *  or
 *
 *  EnumClass::class get { "key" }
 * ```
 *
 * @param λ - the key of which the [TYPE] is associated.
 */
inline infix fun <KEY, reified TYPE> KClass<TYPE>.get(λ: Supplier<KEY>): TYPE? where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { get(enum, λ()) }

/**
 * Returns the collection of [TYPE] of the specified by collection of [keys].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.get("key")
 *
 *  or
 *
 *  EnumClass::class get "key"
 * ```
 *
 * @param keys - the key of which the [TYPE] is associated.
 */
inline infix fun <KEY, reified TYPE> KClass<TYPE>.get(keys: Collection<KEY>): List<TYPE> where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { get(enum, keys) }

/**
 * Returns the collection of [TYPE] of the specified by collection of [λ].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.get { "key" }
 *
 *  or
 *
 *  EnumClass::class get { "key" }
 * ```
 *
 * @param λ - the key of which the [TYPE] is associated.
 */
inline infix fun <KEY, reified TYPE> KClass<TYPE>.get(λ: Supplier<Collection<KEY>>): List<TYPE> where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { get(enum, λ()) }