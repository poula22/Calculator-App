package com.softspire.calculatorapp.presentation.calculator.component

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.softspire.calculatorapp.app.ui.theme.CalculatorAppTheme
import com.softspire.calculatorapp.domain.model.calculator.CalculatorActions
import com.softspire.calculatorapp.presentation.calculator.model.CalculatorActionButtons
import com.softspire.calculatorapp.presentation.calculator.utils.toContainerColor
import com.softspire.calculatorapp.presentation.calculator.utils.toTextColor

@Composable
fun CalculatorActionButton(
    modifier: Modifier = Modifier,
    button: CalculatorActionButtons,
    onAction: (CalculatorActions) -> Unit
) {
    TextButton(
        modifier = modifier.clip(CircleShape),
        colors = ButtonDefaults.textButtonColors(
            containerColor = button.style.highLight.toContainerColor(),
            contentColor = button.style.highLight.toTextColor()
        ),
        shape = CircleShape,
        onClick = { onAction(button.action) },
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = button.symbol,
            fontSize = button.style.textSize
        )
    }
}

@Preview
@Composable
private fun PreviewButton() {
    CalculatorAppTheme {
        CalculatorActionButton(
            button = CalculatorActionButtons.Add,
            onAction = {}
        )
    }
}