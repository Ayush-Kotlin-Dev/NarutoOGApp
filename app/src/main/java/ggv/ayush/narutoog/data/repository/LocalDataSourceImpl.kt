package ggv.ayush.narutoog.data.repository

import ggv.ayush.narutoog.data.local.BorutoDatabase
import ggv.ayush.narutoog.domain.model.Hero
import ggv.ayush.narutoog.domain.repository.LocalDataSource

class LocalDataSourceImpl (borutoDatabase: BorutoDatabase) : LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()
    override suspend fun getSelectedHero(heroId: Int): Hero {
            return heroDao.getSelectedHero(heroId)
    }
}