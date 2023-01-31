package com.mmt.composecalculatorapp.animation_counter_text

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationCounter(
    count: Int,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.body1
) {
    var oldCount by remember {
        mutableStateOf(count)
    }
    SideEffect {
        oldCount = count
    }
    Row(modifier = modifier) {
        val countString = count.toString()
        val oldCountString = oldCount.toString()
        for (i in countString.indices) {
            val oldChar = oldCountString.getOrNull(i)
            val countChar = countString[i]
            val char = if (oldChar == countChar) {
                oldChar
            } else {
                countChar
            }
            AnimatedContent(
                targetState = char,
                transitionSpec = {
                    slideInVertically { it } with slideOutVertically { -it }
                }
            ) { char ->
                Text(
                    text = char.toString(),
                    softWrap = false,
                    style = textStyle
                )
            }
        }
    }
}

@Composable
fun AnimationCounterDemo() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var count by remember {
            mutableStateOf(0)
        }
        AnimationCounter(count = count, textStyle = MaterialTheme.typography.h1)
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = { count++ }) {
            Text(text = "increment")
        }
    }
}