package ggv.ayush.narutoog.data.repository

import ggv.ayush.narutoog.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class Repository @Inject constructor(
    private val dataStore: DataStoreOperations
){

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    fun readOnBoardingState() : Flow<Boolean> = dataStore.getOnBoardingState()
    
}