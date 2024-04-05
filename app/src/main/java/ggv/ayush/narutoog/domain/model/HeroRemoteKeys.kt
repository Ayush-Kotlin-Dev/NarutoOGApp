package ggv.ayush.narutoog.domain.model

import androidx.room.Entity
import ggv.ayush.narutoog.util.Constants.HERO_REMOTE_KEYS_DATABASE_TABLE


@Entity(tableName = HERO_REMOTE_KEYS_DATABASE_TABLE)
data class HeroRemoteKeys(
    @androidx.room.PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)