package com.softspire.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.softspire.calculatorapp.app.ui.theme.CalculatorAppTheme
import com.softspire.calculatorapp.presentation.calculator.CalculatorScreen
import com.softspire.calculatorapp.presentation.calculator.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorAppTheme {
                val viewModel by viewModels<CalculatorViewModel>()
                CalculatorScreen(viewModel)
            }
        }
    }
}