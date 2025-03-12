package com.softspire.calculatorapp.presentation.calculator

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onLast
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.softspire.calculatorapp.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorScreenKtTest {

    @get:Rule
    val compose = createAndroidComposeRule(MainActivity::class.java)
    private lateinit var viewModel: CalculatorViewModel

    @Before
    fun setUp() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun enterExpression_displaysCorrectAnswer() {
        //given
        compose.onNodeWithText("1").performClick()
        compose.onAllNodesWithText("1").onLast().performClick()
        compose.onNodeWithText("+").performClick()
        compose.onAllNodesWithText("1").onLast().performClick()
        //when
        compose.onNodeWithText("=").performClick()
        //then
        compose.onNodeWithText("12.0").assertIsDisplayed()
    }

}