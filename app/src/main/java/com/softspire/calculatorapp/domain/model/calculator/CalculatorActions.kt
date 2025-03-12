package com.softspire.calculatorapp.domain.model.calculator

import com.softspire.calculatorapp.domain.model.experssion.Operations

sealed interface CalculatorActions {
    data class Number(val number: Int) : CalculatorActions
    data class Operation(val operation: Operations) : CalculatorActions
    data object Parentheses : CalculatorActions
    data object Clear : CalculatorActions
    data object Delete : CalculatorActions
    data object Calculate : CalculatorActions
    data object Decimal : CalculatorActions
}