@file:Suppress("NonAsciiCharacters")
@file:[JvmName("KHelperExtensionKt") JvmMultifileClass]

package com.github.tribudirb.kotlin.enum.helper.core

import com.github.tribudirb.kotlin.enum.helper.EnumHelper
import com.github.tribudirb.kotlin.enum.helper.utils.Supplier
import com.github.tribudirb.kotlin.enum.helper.utils.enum
import java.lang.IllegalArgumentException
import kotlin.reflect.KClass

/**
 * Returns the single [TYPE] of the specified [key], or throws exception if there is no or more than one matching element.
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.single("key")
 *
 *  or
 *
 *  EnumClass::class single "key"
 * ```
 *
 * @param key - the key of which the [TYPE] is associated.
 *
 * @throws [NoSuchElementException] if no such element is found.
 * @throws [IllegalArgumentException] when contains more than one element.
 */
@Throws(IllegalArgumentException::class, NoSuchElementException::class)
inline infix fun <KEY, reified TYPE> KClass<TYPE>.single(key: KEY): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { single(enum, key) }

/**
 * Returns the single [TYPE] of the specified [λ], or throws exception if there is no or more than one matching element.
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.single { "key" }
 *
 *  or
 *
 *  EnumClass::class single { "key" }
 * ```
 *
 * @param λ - the key of which the [TYPE] is associated.
 *
 * @throws [NoSuchElementException] if no such element is found.
 * @throws [IllegalArgumentException] when contains more than one element.
 */
@Throws(IllegalArgumentException::class, NoSuchElementException::class)
inline infix fun <KEY, reified TYPE> KClass<TYPE>.single(λ: Supplier<KEY>): TYPE where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { single(enum, λ()) }