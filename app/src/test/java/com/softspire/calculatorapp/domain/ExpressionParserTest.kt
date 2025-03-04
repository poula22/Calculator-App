package com.softspire.calculatorapp.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.softspire.calculatorapp.domain.model.experssion.ExpressionParser
import com.softspire.calculatorapp.domain.model.experssion.ExpressionPart
import com.softspire.calculatorapp.domain.model.experssion.Operations
import com.softspire.calculatorapp.domain.model.experssion.ParenthesesType
import org.junit.Test

class ExpressionParserTest {

    @Test
    fun `simple expression is properly parsed`() {
        //Given
        val expression = "1+2*2-4/6"
        //When
        val actual = ExpressionParser(expression).parse()
        //Then (Assertion)
        val expected = listOf(
            ExpressionPart.Number(1.0),
            ExpressionPart.Operation(Operations.Add),
            ExpressionPart.Number(2.0),
            ExpressionPart.Operation(Operations.Multiply),
            ExpressionPart.Number(2.0),
            ExpressionPart.Operation(Operations.Subtract),
            ExpressionPart.Number(4.0),
            ExpressionPart.Operation(Operations.Divide),
            ExpressionPart.Number(6.0)
        )

        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `expression with parentheses is properly parsed`() {
        //Given
        val expression = "1+(2*2-4/6)"
        //When
        val actual = ExpressionParser(expression).parse()
        //Then (Assertion))
        val expected = listOf(
            ExpressionPart.Number(1.0),
            ExpressionPart.Operation(Operations.Add),
            ExpressionPart.Parentheses(ParenthesesType.Open),
            ExpressionPart.Number(2.0),
            ExpressionPart.Operation(Operations.Multiply),
            ExpressionPart.Number(2.0),
            ExpressionPart.Operation(Operations.Subtract),
            ExpressionPart.Number(4.0),
            ExpressionPart.Operation(Operations.Divide),
            ExpressionPart.Number(6.0),
            ExpressionPart.Parentheses(ParenthesesType.Close)
        )

        assertThat(expected).isEqualTo(actual)
    }
}