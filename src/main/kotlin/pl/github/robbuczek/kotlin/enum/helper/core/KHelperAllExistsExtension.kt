@file:Suppress("NonAsciiCharacters")
@file:kotlin.jvm.JvmName("EnumHelperAllExistsExtensionKt")

package pl.github.robbuczek.kotlin.enum.helper.core

import pl.github.robbuczek.kotlin.enum.helper.EnumHelper
import pl.github.robbuczek.kotlin.enum.helper.utils.Supplier
import pl.github.robbuczek.kotlin.enum.helper.utils.enum
import kotlin.reflect.KClass

/**
 * Returns `true` when [TYPE] contains all of [keys].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.allExists(CollectionOf(something))
 *
 *  or
 *
 *  EnumClass::class allExists CollectionOf(something)
 * ```
 *
 * @param TYPE source
 * @param keys requested elements
 */
inline infix fun <KEY, reified TYPE> KClass<TYPE>.allExists(keys: Collection<KEY>): Boolean where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { allExists(enum, keys) }

/**
 * Returns `true` when [TYPE] contains all of [keys].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.allExists(CollectionOf(something))
 *
 *  or
 *
 *  EnumClass::class allExists CollectionOf(something)
 * ```
 *
 * @param TYPE source
 * @param keys requested elements
 */
inline fun <KEY, reified TYPE> KClass<TYPE>.allExists(vararg keys: KEY): Boolean where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { allExists(enum, keys.toList()) }

/**
 * Returns `true` when [TYPE] contains [λ].
 *
 * In the following example, you can see usage:
 * ```
 *  EnumClass::class.allExists { CollectionOf(something) }
 *
 *  or
 *
 *  EnumClass::class allExists { CollectionOf(something) }
 * ```
 *
 * @param TYPE source
 * @param λ requested elements
 */
inline infix fun <KEY, reified TYPE> KClass<TYPE>.allExists(λ: Supplier<Collection<KEY>>): Boolean where KEY : Any, TYPE : EnumHelper<KEY> =
    EnumHelper.run { allExists(enum, λ()) }