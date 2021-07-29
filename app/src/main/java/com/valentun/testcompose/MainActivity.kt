package com.valentun.testcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.valentun.testcompose.ui.theme.TestComposeTheme
import com.valentun.testcompose.ui.kit.ExpandableBlock
import com.valentun.testcompose.ui.kit.LabeledTextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        ExpandableBlock(title = "Title") {
                            Text(
                                modifier = Modifier.padding(16.dp),
                                text = "Content",
                                style = MaterialTheme.typography.body2,
                            )
                        }

                        LabeledTextView(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            label = "Test", content = "Test"
                        )
                    }
                }
            }
        }
    }
}