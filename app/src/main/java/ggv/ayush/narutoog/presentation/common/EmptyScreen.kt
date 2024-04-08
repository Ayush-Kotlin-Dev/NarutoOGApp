package ggv.ayush.narutoog.presentation.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import ggv.ayush.narutoog.R
import ggv.ayush.narutoog.ui.theme.NETWORK_ERROR_HEIGHT

@Composable
fun EmptyScreen(
    error: LoadState.Error?= null
) {
    var errorMessage by remember {
        mutableStateOf("Find Your Favourite Hero")
    }
    var icon by remember {
        mutableStateOf(R.drawable.search_document)
    }
    if (error != null) {
        errorMessage = parseErrorMessage(message = error.toString())
        icon = R.drawable.network_error
    }
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim by animateFloatAsState(
        targetValue = if(startAnimation) ContentAlpha.disabled else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    LaunchedEffect (key1 = startAnimation){
        startAnimation = true
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(

            modifier = Modifier
                .size(NETWORK_ERROR_HEIGHT)
                .alpha(alphaAnim),
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray
        )

        Text(
            modifier = Modifier
                .padding(top = 16.dp)
                . alpha(alphaAnim),
            text = errorMessage,
            color = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
        )
    }
}

fun parseErrorMessage(message: String): String {
    return when {
        message.contains("404") -> "No data found"
        message.contains("401") -> "Unauthorized"
        message.contains("403") -> "Forbidden"
        message.contains("500") -> "Server error"
        message.contains("ConnectException") -> "Internet Unavailable"

        else -> "Something went wrong"
    }
}
