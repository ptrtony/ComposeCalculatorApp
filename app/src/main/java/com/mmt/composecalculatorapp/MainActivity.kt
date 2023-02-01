package com.mmt.composecalculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mmt.composecalculatorapp.animation_counter_text.AnimationCounterDemo
import com.mmt.composecalculatorapp.calculate.Calculator
import com.mmt.composecalculatorapp.calculate.CalculatorViewModel
import com.mmt.composecalculatorapp.nested_scroll.NestedScrollView
import com.mmt.composecalculatorapp.ui.theme.ComposeCalculatorAppTheme
import com.mmt.composecalculatorapp.ui.theme.MediumGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorAppTheme {
                val viewModel = viewModels<CalculatorViewModel>()
//                val state = viewModel.value.state
//                val buttonSpacing = 8.dp
//                Calculator(
//                    state = state,
//                    buttonSpacing = buttonSpacing,
//                    onAction = viewModel.value::onAction,
//                    modifier = Modifier.fillMaxSize()
//                        .background(color = MediumGray)
//                        .padding(16.dp)
//                )
                NestedScrollView()
            }
        }
    }
}
