package com.softspire.calculatorapp.domain.model.experssion

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionEvaluatorTest {

    @Test
    fun evaluate() {
        val evaluator = ExpressionEvaluator(
            expressionParts = listOf(
                ExpressionPart.Number(1.0),
                ExpressionPart.Operation(Operations.Add),
                ExpressionPart.Number(2.0),
                ExpressionPart.Operation(Operations.Multiply),
                ExpressionPart.Number(2.0),
            )
        )
        val actual = evaluator.evaluate()
        val expected = 5.0
        assertThat(actual).isEqualTo(expected)
    }
}