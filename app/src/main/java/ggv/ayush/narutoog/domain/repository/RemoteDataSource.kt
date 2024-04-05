package ggv.ayush.narutoog.domain.repository

import androidx.paging.PagingData
import ggv.ayush.narutoog.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getAllHeroes(): Flow<PagingData<Hero>>
    suspend fun searchHeroes():Flow<PagingData<Hero>>
}