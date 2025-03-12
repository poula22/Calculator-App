package com.softspire.calculatorapp.presentation.calculator.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.softspire.calculatorapp.presentation.calculator.model.HighlightLevel

@Composable
fun HighlightLevel.toContainerColor(): Color {
    return when (this) {
        HighlightLevel.Neutral -> MaterialTheme.colorScheme.surfaceVariant
        HighlightLevel.SemiHighlighted -> MaterialTheme.colorScheme.inverseSurface
        HighlightLevel.Highlighted -> MaterialTheme.colorScheme.tertiary
        HighlightLevel.StronglyHighlighted -> MaterialTheme.colorScheme.primary
    }
}

@Composable
fun HighlightLevel.toTextColor(): Color {
    return when (this) {
        is HighlightLevel.Neutral -> MaterialTheme.colorScheme.onSurfaceVariant
        is HighlightLevel.SemiHighlighted -> MaterialTheme.colorScheme.inverseOnSurface
        is HighlightLevel.Highlighted -> MaterialTheme.colorScheme.onTertiary
        is HighlightLevel.StronglyHighlighted -> MaterialTheme.colorScheme.onPrimary
    }
}