package com.softspire.calculatorapp.presentation.calculator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.softspire.calculatorapp.presentation.calculator.component.Calculator

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel
) {
    val expression by viewModel.expressionState.collectAsStateWithLifecycle()

    Scaffold(Modifier.fillMaxSize()) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Calculator(
                modifier = Modifier
                    .fillMaxSize(),
                expression = expression,
                onEvent = viewModel::onEvent
            )
        }
    }
}