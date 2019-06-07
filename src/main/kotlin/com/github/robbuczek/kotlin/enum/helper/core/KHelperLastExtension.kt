@file:Suppress("NonAsciiCharacters")
@file:kotlin.jvm.JvmName("EnumHelperLastExtensionKt")

package com.github.robbuczek.kotlin.enum.helper.core

import com.github.robbuczek.kotlin.enum.helper.EnumHelper
import com.github.robbuczek.kotlin.enum.helper.utils.Supplier
import com.github.robbuczek.kotlin.enum.helper.utils.enum
import kotlin.reflect.KClass

/**
 * Returns the last [TYPE] of the specified [keys], or throws exception if no such element is found.
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.last("key")
 *
 *  or
 *
 *  EnumClass::class last "key"
 * ```
 *
 * @param keys - the key of which the [TYPE] is associated.
 *
 * @throws [NoSuchElementException] if no such element is found.
 */
@Throws(NoSuchElementException::class)
inline infix fun <KEY, reified TYPE> KClass<TYPE>.last(keys: Collection<KEY>): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { last(enum, keys) }

/**
 * Returns the last [TYPE] of the specified [keys], or throws exception if no such element is found.
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.last("key")
 *
 *  or
 *
 *  EnumClass::class last "key"
 * ```
 *
 * @param keys - the key of which the [TYPE] is associated.
 *
 * @throws [NoSuchElementException] if no such element is found.
 */
@Throws(NoSuchElementException::class)
inline fun <KEY, reified TYPE> KClass<TYPE>.last(vararg keys: KEY): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { last(enum, keys.toList()) }

/**
 * Returns the last [TYPE] of the specified [λ], or throws exception if no such element is found.
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.last { "key" }
 *
 *  or
 *
 *  EnumClass::class last { "key" }
 * ```
 *
 * @param λ - the keys of which the [TYPE] is associated.
 *
 * @throws [NoSuchElementException] if no such element is found.
 */
@Throws(NoSuchElementException::class)
inline infix fun <KEY, reified TYPE> KClass<TYPE>.last(λ: Supplier<Collection<KEY>>): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { last(enum, λ()) }
