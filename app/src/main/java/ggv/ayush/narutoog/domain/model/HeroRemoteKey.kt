package ggv.ayush.narutoog.domain.model

import androidx.room.Entity
import ggv.ayush.narutoog.util.Constants.HERO_REMOTE_KEY_DATABASE_TABLE


@Entity(tableName = HERO_REMOTE_KEY_DATABASE_TABLE)
data class HeroRemoteKey(
    @androidx.room.PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevKey: Int?,
    val nextKey: Int?
)