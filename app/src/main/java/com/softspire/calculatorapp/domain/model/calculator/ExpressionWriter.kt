package com.softspire.calculatorapp.domain.model.calculator

import com.softspire.calculatorapp.domain.model.experssion.ExpressionEvaluator
import com.softspire.calculatorapp.domain.model.experssion.ExpressionParser
import com.softspire.calculatorapp.domain.model.experssion.ParenthesesType
import com.softspire.calculatorapp.domain.model.experssion.operationSymbols

class ExpressionWriter {
    var expression = ""

    fun processAction(action: CalculatorActions) {
        when (action) {
            CalculatorActions.Calculate -> {
                val parser = ExpressionParser(prepareForeCalculation())
                val evaluator = ExpressionEvaluator(parser.parse())
                expression = evaluator.evaluate().toString()
            }
            CalculatorActions.Clear -> expression = ""
            CalculatorActions.Decimal -> {
                if (canEnterDecimal()) {
                    expression += "."
                }
            }

            CalculatorActions.Delete -> expression = expression.dropLast(1)
            is CalculatorActions.Number -> expression += action.number
            is CalculatorActions.Operation -> {
                if (!canEnterOperation()) return
                expression += action.operation.symbol
            }

            is CalculatorActions.Parentheses -> {
                when {
                    canOpenParentheses() -> {
                        expression += ParenthesesType.Open.symbol
                    }
                    canCloseParentheses() -> {
                        expression += ParenthesesType.Close.symbol
                    }
                    else -> Unit
                }
            }
        }
    }

    private fun prepareForeCalculation(): String {
        val newExpression = expression.dropLastWhile { it in "$operationSymbols(." }
        if (newExpression.isEmpty()) return "0"
        return newExpression
    }

    private fun canCloseParentheses(): Boolean {
        val openParenthesesCount = expression.count { it == ParenthesesType.Open.symbol }
        val closingParenthesesCount = expression.count{ it == ParenthesesType.Close.symbol }

        return expression.isNotEmpty()
                && (expression.last().isDigit() || expression.last() == ParenthesesType.Close.symbol)
                && openParenthesesCount > closingParenthesesCount
    }

    private fun canOpenParentheses(): Boolean {
        return expression.isEmpty() || expression.last() in "$operationSymbols("
    }

    private fun canEnterDecimal(): Boolean {
        if (expression.isEmpty() || expression.last() in "$operationSymbols.()") {
            return false
        }
        return !expression.takeLastWhile {
            it in "0123456789."
        }.contains(".")
    }

    private fun canEnterOperation(): Boolean {
        val lastChar = expression.lastOrNull()
        return !(lastChar == null || lastChar in operationSymbols || lastChar == ParenthesesType.Open.symbol)
    }
}