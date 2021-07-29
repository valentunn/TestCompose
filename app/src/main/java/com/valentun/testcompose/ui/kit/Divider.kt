package com.valentun.testcompose.ui.kit

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.valentun.testcompose.ui.theme.Gray3


@Composable
fun Divider() = androidx.compose.material.Divider(
    modifier = Modifier.padding(horizontal = 16.dp),
    color = Gray3,
    thickness = 1.dp
)