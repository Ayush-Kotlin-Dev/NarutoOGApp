package ggv.ayush.narutoog.data.repository

import androidx.paging.PagingData
import ggv.ayush.narutoog.domain.model.Hero
import ggv.ayush.narutoog.domain.repository.DataStoreOperations
import ggv.ayush.narutoog.domain.repository.LocalDataSource
import ggv.ayush.narutoog.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local : LocalDataSource,
    private val remote : RemoteDataSource,
    private val dataStore: DataStoreOperations
){
     fun getAllHeroes() : Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    fun searchHeroes(query: String) : Flow<PagingData<Hero>> {
        return remote.searchHeroes(query)
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    fun readOnBoardingState() : Flow<Boolean> = dataStore.getOnBoardingState()

    suspend fun getSelectedHero(heroId: Int): Hero {
        return local.getSelectedHero(heroId)
    }
}