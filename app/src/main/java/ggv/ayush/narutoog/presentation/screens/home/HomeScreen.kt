package ggv.ayush.narutoog.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun  HomeScreen() {

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        }
    ){
        Column {
            Text(text = "Home Screen")
        }
    }


}