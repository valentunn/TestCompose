package com.valentun.testcompose.ui.kit

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valentun.testcompose.R
import com.valentun.testcompose.ui.theme.Gray2
import com.valentun.testcompose.ui.theme.TestComposeTheme

@Composable
fun LabeledTextView(
    modifier: Modifier = Modifier,
    label: String,
    content: String,
    contentIcon: Painter? = null
) {
    Column(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .border(1.dp, Gray2, CutCornerShape(topStart = 10.dp, bottomEnd = 10.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)

    ) {
        Text(text = label, style = MaterialTheme.typography.body2)

        Row(
            modifier = Modifier.padding(top = 3.dp),
            verticalAlignment = Alignment.CenterVertically) {
            contentIcon?.let {
                Image(
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    painter = contentIcon
                )
            }

            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = content,
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                // TODO missing center ellipsize
                overflow = TextOverflow.Ellipsis
            )
        }

    }
}


@Preview(showBackground = true, backgroundColor = 0xFF000000L)
@Composable
private fun LabeledTextViewPreview() {
    TestComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            LabeledTextView(
                label = "Address",
                content = "0x000000010101010000",
                contentIcon = painterResource(id = R.drawable.ic_basic_filterlist_24)
            )
        }
    }
}