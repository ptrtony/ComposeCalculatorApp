package com.mmt.composecalculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mmt.composecalculatorapp.shimmer.ShimmerListDemo
import com.mmt.composecalculatorapp.shimmer.ShimmerListItem
import com.mmt.composecalculatorapp.ui.theme.ComposeCalculatorAppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorAppTheme {
//                val viewModel = viewModels<CalculatorViewModel>()
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
//                NestedScrollView()
                ShimmerListDemo()
            }
        }
    }
}
