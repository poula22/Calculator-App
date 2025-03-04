package com.softspire.calculatorapp.domain.model.experssion


/*
* expression: term | term + term | term - term
* term: factor | factor * factor | factor / factor
* factor: number | (expression) | + factor | - factor
*/

class ExpressionEvaluator(
    private val expressionParts: List<ExpressionPart>
) {
    fun evaluate(): Double {
        return evaluateExpression(expressionParts).value
    }

    private fun evaluateFactor(expression: List<ExpressionPart>): ExpressionResult {
        return when (val part = expression.firstOrNull()) {
            is ExpressionPart.Number -> {
                ExpressionResult(expression.drop(1), part.value)
            }

            ExpressionPart.Operation(Operations.Add) -> {
                evaluateFactor(expression.drop(1)).run {
                    ExpressionResult(expressionParts, value)
                }
            }

            ExpressionPart.Operation(Operations.Subtract) -> {
                evaluateFactor(expression.drop(1)).run {
                    ExpressionResult(expressionParts, -value)
                }
            }

            ExpressionPart.Operation(Operations.Multiply) -> {
                evaluateTerm(expression.drop(1))
            }

            ExpressionPart.Operation(Operations.Divide) -> {
                evaluateTerm(expression.drop(1))
            }

            ExpressionPart.Operation(Operations.Percentage) -> {
                evaluateTerm(expression.drop(1))
            }

            ExpressionPart.Parentheses(ParenthesesType.Open) -> {
                evaluateExpression(expression.drop(1)).run {
                    ExpressionResult(expressionParts, value)
                }
            }

            else -> throw IllegalArgumentException("Invalid expression")
        }
    }

    private fun evaluateExpression(remainingExpression: List<ExpressionPart>): ExpressionResult {
        val result = evaluateTerm(remainingExpression)
        var expression = result.remainingExpression
        var sum = result.value

        while (true) {
            when (expression.firstOrNull()) {
                ExpressionPart.Operation(Operations.Add) -> {
                    val term = evaluateTerm(expression.drop(1))
                    sum += term.value
                    expression = term.remainingExpression
                }

                ExpressionPart.Operation(Operations.Subtract) -> {
                    val term = evaluateTerm(expression.drop(1))
                    sum -= term.value
                    expression = term.remainingExpression
                }

                else -> return ExpressionResult(expression, sum)
            }
        }
    }

    private fun evaluateTerm(remainingExpression: List<ExpressionPart>): ExpressionResult {
        val result = evaluateFactor(remainingExpression)
        var expression = result.remainingExpression
        var sum = result.value

        while (true) {
            when (expression.firstOrNull()) {
                ExpressionPart.Operation(Operations.Multiply) -> {
                    val factor = evaluateFactor(expression.drop(1))
                    sum *= factor.value
                    expression = factor.remainingExpression
                }

                ExpressionPart.Operation(Operations.Divide) -> {
                    val factor = evaluateFactor(expression.drop(1))
                    sum /= factor.value
                    expression = factor.remainingExpression
                }

                ExpressionPart.Operation(Operations.Percentage) -> {
                    val factor = evaluateFactor(expression.drop(1))
                    sum %= factor.value
                    expression = factor.remainingExpression
                }

                else -> return ExpressionResult(expression, sum)
            }
        }
    }

    data class ExpressionResult(
        val remainingExpression: List<ExpressionPart>,
        val value: Double
    )
}