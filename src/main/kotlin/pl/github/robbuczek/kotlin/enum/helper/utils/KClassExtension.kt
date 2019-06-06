@file:Suppress("UNCHECKED_CAST")
@file:kotlin.jvm.JvmName("KClassExtensionKt")

package pl.github.robbuczek.kotlin.enum.helper.utils

import kotlin.reflect.KClass

val <T> KClass<T>.enum: Class<Enum<*>> where T: Any
    get() = java as Class<Enum<*>>