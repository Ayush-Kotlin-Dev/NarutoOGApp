package ggv.ayush.narutoog.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import ggv.ayush.narutoog.domain.model.Hero


@Dao
interface HeroDao {
        @Query("SELECT * FROM hero_table ORDER BY id ASC" )
        fun getAllHeroes(): PagingSource<Int, Hero>
}