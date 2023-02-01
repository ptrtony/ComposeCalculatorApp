package com.mmt.composecalculatorapp.nested_scroll

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NestedScrollView() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            subList1()
        }
//        item {
            subList2()
//        }
    }
}

@Composable
fun subList1() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(10) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Red)
            )
        }
    }
}

fun LazyListScope.subList2() {
    items(100) {
        Text(
            text = "Hello World",
            color = Color.Black,
            fontSize = 18.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}