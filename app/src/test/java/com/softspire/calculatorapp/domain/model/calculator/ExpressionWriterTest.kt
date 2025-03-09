package com.softspire.calculatorapp.domain.model.calculator

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.softspire.calculatorapp.domain.model.experssion.Operations
import com.softspire.calculatorapp.domain.model.experssion.ParenthesesType
import org.junit.Before

import org.junit.Test

class ExpressionWriterTest {

    lateinit var writer: ExpressionWriter

    @Before
    fun setUp() {
        writer = ExpressionWriter()
    }

    @Test
    fun `Initial Parentheses parse is correct`() {
        writer.processAction(CalculatorActions.Parentheses)
        writer.processAction(CalculatorActions.Parentheses)
        writer.processAction(CalculatorActions.Number(5))
        writer.processAction(CalculatorActions.Operation(Operations.Add))
        writer.processAction(CalculatorActions.Number(5))
        writer.processAction(CalculatorActions.Decimal)
        writer.processAction(CalculatorActions.Number(5))
        writer.processAction(CalculatorActions.Parentheses)
        writer.processAction(CalculatorActions.Parentheses)

        val actual = writer.expression
        val expected = "((5+5.5))"
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `when calculate result, result is correct`() {
        //given
        writer.processAction(CalculatorActions.Parentheses)
        writer.processAction(CalculatorActions.Parentheses)
        writer.processAction(CalculatorActions.Number(5))
        writer.processAction(CalculatorActions.Operation(Operations.Add))
        writer.processAction(CalculatorActions.Number(5))
        writer.processAction(CalculatorActions.Decimal)
        writer.processAction(CalculatorActions.Number(5))
        writer.processAction(CalculatorActions.Parentheses)
        writer.processAction(CalculatorActions.Operation(Operations.Multiply))
        writer.processAction(CalculatorActions.Number(5))
        writer.processAction(CalculatorActions.Operation(Operations.Divide))
        writer.processAction(CalculatorActions.Number(5))
        writer.processAction(CalculatorActions.Parentheses)

        //When
        writer.processAction(CalculatorActions.Calculate)

        //Then
        val actual = writer.expression
        val expected = "10.5"

        assertThat(actual).isEqualTo(expected)
    }
}