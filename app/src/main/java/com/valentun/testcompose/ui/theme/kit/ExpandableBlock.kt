package com.valentun.testcompose.ui.theme.kit

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valentun.testcompose.ui.theme.TestComposeTheme

@Composable
fun ExpandableBlock(
    title: String,
    content: @Composable () -> Unit,
    ) {
    var isExpanded by remember { mutableStateOf(false) }

    ExpandableBlock(
        title = title,
        toggleClicked = { isExpanded = !isExpanded },
        isExpanded = isExpanded,
        content = content
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandableBlock(
    title: String,
    isExpanded: Boolean,
    toggleClicked: () -> Unit,
    content: @Composable () -> Unit
) {
    val arrowRotationAngle: Float by animateFloatAsState(
        targetValue = if (isExpanded) 180F else 0F
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = toggleClicked)
                .padding(16.dp)
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = title,
                style = MaterialTheme.typography.body1,
            )

            Image(
                modifier = Modifier.rotate(arrowRotationAngle),
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.White)
            )
        }

        Divider()

        AnimatedVisibility(
            visible = isExpanded
        ) {
            content()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000L)
@Composable
fun ExpandableBlockPreview() {
    TestComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            ExpandableBlock(title = "Title") {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "Content",
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}