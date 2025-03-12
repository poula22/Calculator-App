package com.softspire.calculatorapp.presentation.calculator.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.softspire.calculatorapp.app.ui.theme.CalculatorAppTheme
import com.softspire.calculatorapp.domain.model.calculator.CalculatorActions

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    expression: String,
    onEvent: (CalculatorActions) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        CalculatorDisplay(
            expression = expression,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 25.dp,
                        bottomEnd = 25.dp
                    )
                )
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(
                    vertical = 64.dp,
                    horizontal = 16.dp
                )
        )

        CalculatorActionButtonsGrid(
            modifier = Modifier.padding(16.dp),
            onAction = onEvent
        )
    }
}

@Preview
@Composable
private fun PreviewCalc() {
    CalculatorAppTheme {
        Calculator(
            expression = "2*2",
            onEvent = {}
        )
    }
}