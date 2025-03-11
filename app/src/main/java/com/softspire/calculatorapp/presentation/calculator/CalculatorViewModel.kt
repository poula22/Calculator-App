package com.softspire.calculatorapp.presentation.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.softspire.calculatorapp.CalculatorApp
import com.softspire.calculatorapp.domain.model.calculator.CalculatorActions
import com.softspire.calculatorapp.domain.model.calculator.ExpressionWriter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel(
    private val expressionWriter: ExpressionWriter = ExpressionWriter()
): ViewModel() {
    private val _expressionState = MutableStateFlow("")
    val expressionState = _expressionState.asStateFlow()

    fun onEvent(event: CalculatorActions) {
        expressionWriter.processAction(event)
        _expressionState.update {
            expressionWriter.expression
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])

                return CalculatorViewModel(
                    (application as CalculatorApp).expressionWriter
                ) as T
            }
        }
    }
}