package ggv.ayush.narutoog.presentation.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ggv.ayush.narutoog.domain.use_cases.UseCases
import javax.inject.Inject


class SearchViewModel() : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }


}