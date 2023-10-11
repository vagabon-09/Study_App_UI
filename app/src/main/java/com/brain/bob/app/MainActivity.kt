package com.brain.bob.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brain.bob.app.ui.theme.BrainBobAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(showSystemUi = true)
    @Composable
    fun DefaultPreview() {
        val genres = listOf("BrainStorm", "Books", "Videos", "Others")
        BrainBobAppTheme {
            Scaffold {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(it)
                        .padding(horizontal = 20.dp)

                ) {
                    Text(fontSize = 40.sp,
                        modifier = Modifier.padding(bottom = 25.dp),
                        text = buildAnnotatedString {
                            append("Choose what")
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                )
                            ) {
                                append("\n\nto learn today?")
                            }
                        })
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.padding(bottom = 25.dp)
                    ) {
                        items(genres) { genres ->
                            Genres(genres)
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .clip(RoundedCornerShape(15))
                            .background(colorResource(id = R.color.main))
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Column(
                                modifier = Modifier
                                    .padding(vertical = 30.dp)
                                    .padding(start = 20.dp, end = 20.dp)
                            ) {
                                Text(
                                    text = "Vocabulary",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 32.sp
                                )

                            }
                        }
                    }
                }

            }
        }
    }

    @Composable
    private fun Genres(text: String) {
        var isSelected by remember { mutableStateOf(false) }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(30))
                .background(if (isSelected) Color.Black else colorResource(id = R.color.seal))
                .clickable { isSelected = !isSelected }, contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(7.dp),
                text = text,
                color = if (isSelected) Color.White else Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }


}



