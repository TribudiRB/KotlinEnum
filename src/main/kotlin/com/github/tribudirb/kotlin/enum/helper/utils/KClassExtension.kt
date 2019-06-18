@file:Suppress("UNCHECKED_CAST")
@file:kotlin.jvm.JvmName("KClassExtensionKt")

package com.github.tribudirb.kotlin.enum.helper.utils

import kotlin.reflect.KClass

/**
 * Returns a Java [Enum] instance corresponding to the given [KClass] instance.
 */
val <T> KClass<T>.enum: Class<Enum<*>> where T: Any
    get() = java as Class<Enum<*>>