package ggv.ayush.narutoog.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import ggv.ayush.narutoog.data.local.dao.HeroDao
import ggv.ayush.narutoog.data.local.dao.HeroRemoteKeyDao
import ggv.ayush.narutoog.domain.model.Hero
import ggv.ayush.narutoog.domain.model.HeroRemoteKey



@Database(entities = [Hero::class , HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}