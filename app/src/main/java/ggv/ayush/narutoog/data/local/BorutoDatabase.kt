package ggv.ayush.narutoog.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ggv.ayush.narutoog.data.local.dao.HeroDao
import ggv.ayush.narutoog.domain.model.Hero

@Database(
    entities = [Hero::class],
    version = 1
)
abstract class BorutoDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao
}