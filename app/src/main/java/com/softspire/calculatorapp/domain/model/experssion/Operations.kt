package com.softspire.calculatorapp.domain.model.experssion

enum class Operations(val symbol: String) {
    Add("+"),
    Subtract("-"),
    Multiply("x"),
    Divide("/"),
    Percentage("%")
}

val operationSymbols = Operations.entries.joinToString("") { it.symbol }