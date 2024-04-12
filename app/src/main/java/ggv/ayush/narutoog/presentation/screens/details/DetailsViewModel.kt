package ggv.ayush.narutoog.presentation.screens.details

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ggv.ayush.narutoog.domain.model.Hero
import ggv.ayush.narutoog.domain.use_cases.UseCases
import ggv.ayush.narutoog.util.Constants.DETAILS_ARGUMENT_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCases: UseCases,
    saveStateHandle : SavedStateHandle
):ViewModel() {
    private val _selectedHero:MutableStateFlow<Hero?> = MutableStateFlow(null)
    val selectedHero:StateFlow<Hero?> = _selectedHero

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val heroId = saveStateHandle.get<Int>(DETAILS_ARGUMENT_KEY)
            _selectedHero.value = heroId?.let { useCases.getSelectedHeroUsecase(heroId) }
            _selectedHero.value?.name?.let {
                Log.d("hero" ,it)
            }
        }

    }
    private val _uiEvent = MutableSharedFlow<uiEvent>()
    val uiEvent : SharedFlow<uiEvent> = _uiEvent.asSharedFlow()

    private val _colorPalette : MutableState<Map<String , String>> = mutableStateOf(mapOf())
    val colorPalette : MutableState<Map<String , String>> = _colorPalette
    fun generateColorPalette(){
        viewModelScope.launch {
            _uiEvent.emit(ggv.ayush.narutoog.presentation.screens.details.uiEvent.GenerateColorPalette)
        }
    }

    fun setColorPalette(colors: Map<String , String>){
        _colorPalette.value = colors
    }


}

sealed class uiEvent{
    object GenerateColorPalette : uiEvent()
}