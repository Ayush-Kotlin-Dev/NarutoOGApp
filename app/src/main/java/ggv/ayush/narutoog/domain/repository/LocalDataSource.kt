package ggv.ayush.narutoog.domain.repository

import ggv.ayush.narutoog.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero

}