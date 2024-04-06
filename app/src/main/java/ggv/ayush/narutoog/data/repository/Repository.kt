package ggv.ayush.narutoog.data.repository

import androidx.paging.PagingData
import ggv.ayush.narutoog.domain.model.Hero
import ggv.ayush.narutoog.domain.repository.DataStoreOperations
import ggv.ayush.narutoog.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote : RemoteDataSource,
    private val dataStore: DataStoreOperations
){
     fun getAllHeroes() : Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    fun readOnBoardingState() : Flow<Boolean> = dataStore.getOnBoardingState()
}