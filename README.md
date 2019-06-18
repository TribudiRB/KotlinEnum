# [kotlin-enum helper](https://github.com/TribudiRB/KotlinEnum) [![License: MIT](https://img.shields.io/badge/License-MIT-GREEN.svg)](https://opensource.org/licenses/MIT)

Lightweight enum helper for Kotlin, written in [![Pure Kotlin](https://img.shields.io/badge/100%25-kotlin-green.svg)](https://kotlinlang.org/).  
A convenient and performance utility library wrapping basic enum operation as an extensions.

## Overview

After seeing many weird implementations of `getOrDefault()`, it seems like there should be a standard for converting to enum and obtaining basic information from it.
Kotlin-enum helper provide a generic implementation which can be easy applied to any enum:
  - No need to write the crappy boilerplate code.
  - It cover most of common behaviours e.g `getOrDefault()` or `get()`.


## Getting started
****Implement interface EnumHelper****
```Kotlin
enum class Money(override val key: String) : EnumHelper<String> {
    EURO("€"),
    DOLAR("$"),
    STERLING("£"),
    POLISH_ZLOTY("PLN")
}
```

## Usage
```Kotlin
fun getOrDefaultCurrencyFrom(sign: String) : Money = Money::class.getOrDefault(key = sign, default = Money.POUND)

fun checkAllCurrencyAreValid(signs: List<String>) : Boolean = Money::class allExists signs

fun getCurrencyFrom(sign: String) : Money = Money::class get { sign }
```

## Download
#### Maven
```xml
<dependency>
  <groupId>com.github.tribudirb</groupId>
  <artifactId>kotlin-enum-helper</artifactId>
  <version>1.0.0</version>
</dependency>
```

Or alternatively, download jar from [github](https://github.com/TribudiRB/KotlinEnum/releases).

### Contributors

- Robert Buczek

### Contributing 
**Pull requests are welcome**

