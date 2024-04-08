package ggv.ayush.narutoog.presentation.screens.search

import SearchTopBar
import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery by searchViewModel.searchQuery
    val heroes = searchViewModel.searchedHeroes.collectAsLazyPagingItems()


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
            // SearchContent()
        }
    )
}