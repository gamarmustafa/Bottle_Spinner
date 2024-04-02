package com.example.bottlespinner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity :ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottleSpinner()
        }
    }
}

@Composable
fun BottleSpinner() {
    var rotation by remember { mutableFloatStateOf(0f) }
    val interactionSource = remember { MutableInteractionSource() }
    val animatedRotation by animateFloatAsState(
        targetValue = rotation,
        animationSpec = spring(10f,2000f), label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .clickable(indication = null, interactionSource = interactionSource) {
                rotation += Random.nextInt(400, 1500)
            }

    ) {
        Icon(
            painter = painterResource(id = R.drawable.bottle),
            contentDescription = "",
            modifier = Modifier
                .size(260.dp)
                .align(Alignment.Center)
                .padding(16.dp)
                .graphicsLayer(rotationZ = animatedRotation)

        )

    }

}

@Preview
@Composable
fun Preview() {
    BottleSpinner()
}