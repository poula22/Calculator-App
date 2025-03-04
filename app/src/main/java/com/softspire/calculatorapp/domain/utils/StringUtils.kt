package com.softspire.calculatorapp.domain.utils

import com.softspire.calculatorapp.domain.model.experssion.ExpressionPart
import com.softspire.calculatorapp.domain.model.experssion.Operations
import com.softspire.calculatorapp.domain.model.experssion.ParenthesesType
import com.softspire.calculatorapp.domain.model.experssion.operationSymbols

fun String.toExpressionPartList(): List<ExpressionPart> {
    return this.filter { it != ' ' }
        .toCharArray()
        .map { it.toExpressionPart() }
}

private fun Char.toExpressionPart(): ExpressionPart {
    return when {
        isDigit() -> ExpressionPart.Number(this.toString().toDouble())
        this in operationSymbols -> ExpressionPart.Operation(toString().operationFromSymbol())
        this == '(' -> ExpressionPart.Parentheses(ParenthesesType.Open)
        this == ')' -> ExpressionPart.Parentheses(ParenthesesType.Close)
        else -> throw IllegalArgumentException("Invalid symbol $this must match [0-9] | $operationSymbols | ( | )")
    }
}

private fun String.operationFromSymbol(): Operations {
    return Operations.entries
        .find {
            it.symbol == this
        } ?: throw IllegalArgumentException("Invalid symbol")
}