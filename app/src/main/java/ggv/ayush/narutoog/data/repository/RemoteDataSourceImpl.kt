package ggv.ayush.narutoog.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.room.Query
import ggv.ayush.narutoog.data.local.BorutoDatabase
import ggv.ayush.narutoog.data.pagingsource.HeroRemoteMediator
import ggv.ayush.narutoog.data.pagingsource.SearchHeroesSource
import ggv.ayush.narutoog.data.remote.BorutoApi
import ggv.ayush.narutoog.domain.model.Hero
import ggv.ayush.narutoog.domain.repository.RemoteDataSource
import ggv.ayush.narutoog.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
@OptIn(ExperimentalPagingApi::class)

class RemoteDataSourceImpl(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase
) : RemoteDataSource {

    val heroDao = borutoDatabase.heroDao()
    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi,
                borutoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override  fun searchHeroes( query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi,
                borutoDatabase
            ),
            pagingSourceFactory = {
                SearchHeroesSource(
                    borutoApi,
                    query = query
                )
            }
        ).flow
    }
}
