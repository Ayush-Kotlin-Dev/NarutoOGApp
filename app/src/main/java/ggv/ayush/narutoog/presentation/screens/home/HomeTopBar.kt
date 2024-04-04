package ggv.ayush.narutoog.presentation.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ggv.ayush.narutoog.R
import ggv.ayush.narutoog.ui.theme.LightGrey
import ggv.ayush.narutoog.ui.theme.Purple500

@Composable
fun HomeTopBar(
    onSearchClicked : () -> Unit
) {
    val topBarContentColor = if(isSystemInDarkTheme()) Color.LightGray else Color.White
    val topBarBackgroundColor = if(isSystemInDarkTheme()) Color.Black else Purple500


    TopAppBar(
        
        title = {
            Text(
                text = "Explore",
                color = topBarContentColor
            )
        },
        backgroundColor = topBarBackgroundColor,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon)
                )

            }
        }
    )
}

@Composable
@Preview
fun HomeTopBarPreview() {
    HomeTopBar(onSearchClicked = {})
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun HomeTopBarDsrkPreview() {
    HomeTopBar(onSearchClicked = {})
}