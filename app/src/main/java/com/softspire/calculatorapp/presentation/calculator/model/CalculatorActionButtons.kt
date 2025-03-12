package com.softspire.calculatorapp.presentation.calculator.model

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.softspire.calculatorapp.domain.model.calculator.CalculatorActions
import com.softspire.calculatorapp.domain.model.experssion.Operations

@Stable
enum class CalculatorActionButtons(
    val symbol: String,
    val action: CalculatorActions,
    val style: CalculatorButtonStyle
) {
    Clear("AC", CalculatorActions.Clear, CalculatorButtonStyle.Clear),
    OpenParentheses("()", CalculatorActions.Parentheses, CalculatorButtonStyle.Parentheses),
    Percentage("%", CalculatorActions.Operation(Operations.Percentage), CalculatorButtonStyle.Operation),
    Divide("/", CalculatorActions.Operation(Operations.Divide), CalculatorButtonStyle.Operation),
    Seven("7", CalculatorActions.Number(7), CalculatorButtonStyle.Number),
    Eight("8", CalculatorActions.Number(8), CalculatorButtonStyle.Number),
    Nine("9", CalculatorActions.Number(9), CalculatorButtonStyle.Number),
    Multiply("X", CalculatorActions.Operation(Operations.Multiply), CalculatorButtonStyle.Operation),
    Four("4", CalculatorActions.Number(4), CalculatorButtonStyle.Number),
    Five("5", CalculatorActions.Number(5), CalculatorButtonStyle.Number),
    Six("6", CalculatorActions.Number(6), CalculatorButtonStyle.Number),
    Subtract("-", CalculatorActions.Operation(Operations.Subtract), CalculatorButtonStyle.Operation),
    One("1", CalculatorActions.Number(1), CalculatorButtonStyle.Number),
    Two("2", CalculatorActions.Number(2), CalculatorButtonStyle.Number),
    Three("3", CalculatorActions.Number(3), CalculatorButtonStyle.Number),
    Add("+", CalculatorActions.Operation(Operations.Add), CalculatorButtonStyle.Operation),
    Zero("0", CalculatorActions.Number(0), CalculatorButtonStyle.Number),
    Decimal(".", CalculatorActions.Decimal, CalculatorButtonStyle.Number),
    Delete("<-", CalculatorActions.Delete, CalculatorButtonStyle.Delete),
    Equals("=", CalculatorActions.Calculate, CalculatorButtonStyle.Calculate),
}

@Stable
sealed class CalculatorButtonStyle(
    val textSize: TextUnit,
    val highLight: HighlightLevel
) {

    data object  Delete: CalculatorButtonStyle(
        textSize = 36.sp,
        highLight = HighlightLevel.Neutral
    )

    data object Clear : CalculatorButtonStyle(
        textSize = 36.sp,
        highLight = HighlightLevel.Neutral
    )

    data object Operation : CalculatorButtonStyle(
        textSize = 36.sp,
        highLight = HighlightLevel.Neutral
    )

    data object Parentheses: CalculatorButtonStyle(
        textSize = 36.sp,
        highLight = HighlightLevel.Neutral
    )

    data object Number: CalculatorButtonStyle(
        textSize = 36.sp,
        highLight = HighlightLevel.Neutral
    )

    data object Calculate: CalculatorButtonStyle(
        textSize = 36.sp,
        highLight = HighlightLevel.Neutral
    )
}

@Stable
sealed interface HighlightLevel {
    data object Neutral : HighlightLevel
    data object SemiHighlighted : HighlightLevel
    data object Highlighted : HighlightLevel
    data object StronglyHighlighted : HighlightLevel
}