package com.softspire.calculatorapp.presentation.calculator.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.softspire.calculatorapp.domain.model.calculator.CalculatorActions
import com.softspire.calculatorapp.presentation.calculator.model.CalculatorActionButtons

@Composable
fun CalculatorActionButtonsGrid(
    modifier: Modifier = Modifier,
    onAction: (CalculatorActions) -> Unit
) {

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(4),
        userScrollEnabled = false,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(CalculatorActionButtons.entries) { button ->
                CalculatorActionButton(
                    modifier = Modifier.aspectRatio(1f),
                    button = button,
                    onAction = onAction
                )
            }
        }
    )
}