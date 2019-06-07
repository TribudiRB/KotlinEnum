@file:Suppress("NonAsciiCharacters")
@file:kotlin.jvm.JvmName("EnumHelperFirstExtensionKt")

package com.github.robbuczek.kotlin.enum.helper.core

import com.github.robbuczek.kotlin.enum.helper.EnumHelper
import com.github.robbuczek.kotlin.enum.helper.utils.Supplier
import com.github.robbuczek.kotlin.enum.helper.utils.enum
import java.lang.IllegalArgumentException
import kotlin.reflect.KClass

/**
 * Returns the first [TYPE] of the specified [key], or throws exception if no such element is found.
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.first("key")
 *
 *  or
 *
 *  EnumClass::class first "key"
 * ```
 *
 * @param key - the key of which the [TYPE] is associated.
 *
 * @throws [NoSuchElementException] if no such element is found.
 * @throws [IllegalArgumentException] when contains more than one element.
 */
@Throws(NoSuchElementException::class)
inline infix fun <KEY, reified TYPE> KClass<TYPE>.first(key: Collection<KEY>): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { first(enum, key) }

/**
 * Returns the first [TYPE] of the specified [keys], or throws exception if no such element is found.
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.first("key")
 * ```
 *
 * @param keys - the key of which the [TYPE] is associated.
 *
 * @throws [NoSuchElementException] if no such element is found.
 * @throws [IllegalArgumentException] when contains more than one element.
 */
@Throws(NoSuchElementException::class)
inline fun <KEY, reified TYPE> KClass<TYPE>.first(vararg keys: KEY): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { first(enum, keys.toList()) }

/**
 * Returns the first [TYPE] of the specified [λ], or throws exception if no such element is found.
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.first { "key" }
 *
 *  or
 *
 *  EnumClass::class first { "key" }
 * ```
 *
 * @param λ - the key of which the [TYPE] is associated.
 *
 * @throws [NoSuchElementException] if no such element is found.
 */
@Throws(NoSuchElementException::class)
inline infix fun <KEY, reified TYPE> KClass<TYPE>.first(λ: Supplier<Collection<KEY>>): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { first(enum, λ()) }