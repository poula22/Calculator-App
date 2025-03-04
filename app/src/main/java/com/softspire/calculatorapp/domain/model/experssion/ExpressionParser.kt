package com.softspire.calculatorapp.domain.model.experssion

import com.softspire.calculatorapp.domain.utils.toExpressionPartList

class ExpressionParser(
    private val expression: String
) {
    fun parse(): List<ExpressionPart> {
        return expression.toExpressionPartList()
    }

}