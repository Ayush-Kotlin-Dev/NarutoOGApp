package ggv.ayush.narutoog.presentation.screens.search

import SearchTopBar
import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun SearchScreen() {

    Scaffold(
        topBar = {
            SearchTopBar(
                text = "Search",
                onTextChange = { /*TODO*/ },
                onCloseClicked = { /*TODO*/ },
                onSearchClicked = { /*TODO*/ },
            )
        },
        content = {
            // SearchContent()
        }
    )
}