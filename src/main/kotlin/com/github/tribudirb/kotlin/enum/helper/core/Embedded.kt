package com.github.tribudirb.kotlin.enum.helper.core

import com.github.tribudirb.kotlin.enum.helper.EnumHelper
import com.github.tribudirb.kotlin.enum.helper.utils.EnumClass

/**
 * Embedded common functionality, which is missing in enum implementation.
 */
open class Embedded {

    /**
     * Returns the [ENUM_TYPE] of the specified [key].
     *
     * @param enums source.
     * @param key - the key of which the [ENUM_TYPE] is associated.
     */
    inline fun <reified ENUM_TYPE, KEY> get(
        enums: EnumClass,
        key: KEY
    ): ENUM_TYPE? where KEY : Any, ENUM_TYPE : EnumHelper<KEY> =
        enums.enumConstants.find { (it as ENUM_TYPE).key == key } as ENUM_TYPE?

    /**
     * Returns the collection of [ENUM_TYPE] of the specified by collection of [keys].
     *
     * @param enums source.
     * @param keys - the key of which the [ENUM_TYPE] is associated.
     */
    inline fun <reified ENUM_TYPE, KEY> get(
        enums: EnumClass,
        keys: Collection<KEY>
    ): List<ENUM_TYPE> where KEY : Any, ENUM_TYPE : EnumHelper<KEY> =
        enums.enumConstants.map { it as ENUM_TYPE }.filter { keys.contains(it.key) }

    /**
     * Returns the single [ENUM_TYPE] of the specified [key], or throws exception if there is no or more than one matching element.
     *
     * @param enums source.
     * @param key - the key of which the [ENUM_TYPE] is associated.
     *
     * @throws [NoSuchElementException] if no such element is found.
     * @throws [IllegalArgumentException] when contains more than one element.
     */
    @Throws(IllegalArgumentException::class, NoSuchElementException::class)
    inline fun <reified ENUM_TYPE, KEY> single(
        enums: EnumClass,
        key: KEY
    ): ENUM_TYPE where KEY : Any, ENUM_TYPE : EnumHelper<KEY> =
        enums.enumConstants.single { (it as ENUM_TYPE).key == key } as ENUM_TYPE

    /**
     * Returns the first [ENUM_TYPE] of the specified [keys], or throws exception if no such element is found.
     *
     * @param enums source.
     * @param keys - the key of which the [ENUM_TYPE] is associated.
     *
     * @throws [NoSuchElementException] if no such element is found.
     */
    @Throws(NoSuchElementException::class)
    inline fun <reified ENUM_TYPE, KEY> first(
        enums: EnumClass,
        keys: Collection<KEY>
    ): ENUM_TYPE where KEY : Any, ENUM_TYPE : EnumHelper<KEY> {
        for (key in keys) {
            for (enum in enums.enumConstants) when (key) {
                (enum as ENUM_TYPE).key -> return enum
            }
        }

        throw NoSuchElementException("Enum contains no element matching to the keys.")
    }

    /**
     * Returns the last [ENUM_TYPE] of the specified [keys], or throws exception if no such element is found.
     *
     * @param enums source.
     * @param keys - the key of which the [ENUM_TYPE] is associated.
     *
     * @throws [NoSuchElementException] if no such element is found.
     */
    @Throws(NoSuchElementException::class)
    inline fun <reified ENUM_TYPE, KEY> last(
        enums: EnumClass,
        keys: Collection<KEY>
    ): ENUM_TYPE where KEY : Any, ENUM_TYPE : EnumHelper<KEY> {
        for (key in keys.reversed()) {
            for (enum in enums.enumConstants) when (key) {
                (enum as ENUM_TYPE).key -> return enum
            }
        }

        throw NoSuchElementException("Enum contains no element matching to the keys.")
    }

    /**
     * Returns the value of [ENUM_TYPE] to which the specified [key] is mapped, or [default] if this value not exist in this [ENUM_TYPE].
     *
     * @param enums source.
     * @param key requested element.
     * @param default the default value when [key] not exists.
     */
    inline fun <reified ENUM_TYPE, KEY> getOrDefault(
        enums: EnumClass,
        key: KEY,
        default: ENUM_TYPE
    ): ENUM_TYPE where KEY : Any, ENUM_TYPE : EnumHelper<KEY> =
        enums.enumConstants.find { (it as ENUM_TYPE).key == key } as ENUM_TYPE? ?: default

    /**
     * Returns the list of [ENUM_TYPE] of the specified collection [keys], or [default] when result is empty.
     *
     * @param enums source.
     * @param keys requested element.
     * @param default the default collection when result is empty.
     */
    inline fun <reified ENUM_TYPE, KEY> getOrDefault(
        enums: EnumClass,
        keys: Collection<KEY>,
        default: List<ENUM_TYPE>
    ): List<ENUM_TYPE> where KEY : Any, ENUM_TYPE : EnumHelper<KEY> =
        enums.enumConstants.map { it as ENUM_TYPE }.filter { keys.contains(it.key) }.ifEmpty { default }

    /**
     * Returns the collection of [ENUM_TYPE] of the specified collection [keys], or [default] when result is empty.
     *
     * @param enums source.
     * @param keys requested element.
     * @param default the default value when result is empty.
     */
    inline fun <reified ENUM_TYPE, KEY> getOrDefault(
        enums: EnumClass,
        keys: Collection<KEY>,
        default: ENUM_TYPE
    ): List<ENUM_TYPE> where KEY : Any, ENUM_TYPE : EnumHelper<KEY> =
        enums.enumConstants.map { it as ENUM_TYPE }.filter { keys.contains(it.key) }.ifEmpty { listOf(default) }

    /**
     * Returns the value of [ENUM_TYPE] which is corresponding to the [keys], or [default] when empty.
     *
     * @param enums source.
     * @param keys requested elements.
     * @param default when empty.
     */
    inline fun <reified ENUM_TYPE, KEY> anyOrDefault(
        enums: EnumClass,
        keys: Collection<KEY>,
        default: ENUM_TYPE
    ): ENUM_TYPE where KEY : Any, ENUM_TYPE : EnumHelper<KEY> =
        enums.enumConstants.firstOrNull { keys.contains((it as ENUM_TYPE).key) } as ENUM_TYPE? ?: default

    /**
     * Returns `true` when [enums] contains all of [keys].
     *
     * @param enums source
     * @param keys requested elements
     */
    inline fun <reified ENUM_TYPE, KEY> allExists(
        enums: EnumClass,
        keys: Collection<KEY>
    ): Boolean where KEY : Any, ENUM_TYPE : EnumHelper<KEY> =
        enums.enumConstants.map { (it as ENUM_TYPE).key }.containsAll(keys)

    /**
     * Returns `true` when [enums] contains one or more of [keys].
     *
     * @param enums source.
     * @param keys requested elements
     */
    inline fun <reified ENUM_TYPE, KEY> anyExists(
        enums: EnumClass,
        keys: Collection<KEY>
    ): Boolean where KEY : Any, ENUM_TYPE : EnumHelper<KEY> =
        enums.enumConstants.any { keys.contains((it as ENUM_TYPE).key) }
}