package com.mmt.composecalculatorapp.shimmer

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


@Composable
fun ShimmerListItem(
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    contentAfterLoading: @Composable ()-> Unit
) {
    if (isLoading) {
        Row(modifier = modifier) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(20.dp)
                        .shimmerEffect()
                )
            }
        }
    } else {
        contentAfterLoading()
    }
}

fun Modifier.shimmerEffect():Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition()
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        )
    )
    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFB4B4B4),
                Color(0xFF797878),
                Color(0xFFB4B4B4),
            ),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    ).onGloballyPositioned {
        size = it.size
    }
}

@Composable
fun ShimmerListDemo() {
    var isLoading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = isLoading) {
        delay(10000)
        isLoading = false
    }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(100) {
            ShimmerListItem(
                isLoading = isLoading,
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier =
                    Modifier.fillMaxWidth()
                        .padding(10.dp)
                    ,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = null)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "RememberInfiniteTransition is similar, but it creates an infinite transition that can manage multiple animations that keep on running indefinitely. All of these ..."
                    )
                }
            }
        }
    }
}