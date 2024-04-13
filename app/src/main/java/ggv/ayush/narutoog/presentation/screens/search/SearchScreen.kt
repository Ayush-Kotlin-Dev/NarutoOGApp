package ggv.ayush.narutoog.presentation.screens.search

import SearchTopBar
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ggv.ayush.narutoog.presentation.common.ListContent
import ggv.ayush.narutoog.ui.theme.HERO_ITEM_HEIGHT
import ggv.ayush.narutoog.ui.theme.MEDIUM_PADDING
import ggv.ayush.narutoog.ui.theme.Purple700

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery by searchViewModel.searchQuery
    val heroes = searchViewModel.searchedHeroes.collectAsLazyPagingItems()
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = if(isSystemInDarkTheme()) Color.Black else Purple700
    )
    systemUiController.setNavigationBarColor(
        color = if(isSystemInDarkTheme()) Color.Black else MaterialTheme.colors.surface.copy(alpha = 0.95f)
    )


    Scaffold(
        topBar = {
            SearchTopBar(
                text = searchQuery,
                onTextChange = {
                    searchViewModel.updateSearchQuery(it)
                    },
                onCloseClicked = {
                    navController.popBackStack()
                                 },
                onSearchClicked = {
                    searchViewModel.searchHeroes(searchQuery)
                                  },
            )
        },
        content = {
            ListContent(
                heroes = heroes,
                navController = navController,
                modifier = Modifier
                    .padding(top = 55.dp)
            )
        }
    )
}