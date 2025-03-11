package com.softspire.calculatorapp.domain.utils

import com.softspire.calculatorapp.domain.model.experssion.ExpressionPart
import com.softspire.calculatorapp.domain.model.experssion.Operations
import com.softspire.calculatorapp.domain.model.experssion.ParenthesesType
import com.softspire.calculatorapp.domain.model.experssion.operationSymbols

fun String.toExpressionPartList(): List<ExpressionPart> {
    val result = mutableListOf<ExpressionPart>()
    var index = 0
    while (index < this.length) {
        val char = this[index]
        if (char.isDigit()) {
            val numberAsString = buildString {
                while(index < this@toExpressionPartList.length && this@toExpressionPartList[index] in "0123456789.") {
                    append(this@toExpressionPartList[index])
                    index++
                }
            }
            result.add(ExpressionPart.Number(numberAsString.toDouble()))
        } else {
            result.add(this[index].toExpressionPart())
            index++
        }
    }
    return result
}

private fun Char.toExpressionPart(): ExpressionPart {
    return when(this) {
        in operationSymbols -> ExpressionPart.Operation(toString().operationFromSymbol())
        '(' -> ExpressionPart.Parentheses(ParenthesesType.Open)
        ')' -> ExpressionPart.Parentheses(ParenthesesType.Close)
        else -> throw IllegalArgumentException("Invalid symbol $this must match [0-9] | $operationSymbols | ( | )")
    }
}

private fun String.operationFromSymbol(): Operations {
    return Operations.entries
        .find {
            it.symbol == this
        } ?: throw IllegalArgumentException("Invalid symbol")
}