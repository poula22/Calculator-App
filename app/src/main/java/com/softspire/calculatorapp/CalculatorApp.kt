package com.softspire.calculatorapp

import android.app.Application
import com.softspire.calculatorapp.domain.model.calculator.ExpressionWriter

class CalculatorApp: Application() {
    val expressionWriter = ExpressionWriter()
}