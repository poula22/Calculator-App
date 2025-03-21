package com.softspire.calculatorapp.domain.model.experssion

sealed interface ExpressionPart {
    data class Number(val value: Double) : ExpressionPart
    data class Operation(val operation: Operations) : ExpressionPart
    data class Parentheses(val type: ParenthesesType) : ExpressionPart
}

sealed class ParenthesesType(val symbol: Char) {
    data object Open : ParenthesesType('(')
    data object Close : ParenthesesType(')')
}