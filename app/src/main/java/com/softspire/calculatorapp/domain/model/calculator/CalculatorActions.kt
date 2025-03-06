package com.softspire.calculatorapp.domain.model.calculator

import com.softspire.calculatorapp.domain.model.experssion.Operations
import com.softspire.calculatorapp.domain.model.experssion.ParenthesesType

sealed interface CalculatorActions {
    data class Number(val number: Int) : CalculatorActions
    data class Operation(val operation: Operations) : CalculatorActions
    data class Parentheses(val type: ParenthesesType) : CalculatorActions
    data object Clear : CalculatorActions
    data object Delete : CalculatorActions
    data object Calculate : CalculatorActions
    data object Decimal : CalculatorActions
}