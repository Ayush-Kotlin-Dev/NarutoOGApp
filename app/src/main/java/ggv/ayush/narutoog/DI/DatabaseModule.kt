package ggv.ayush.narutoog.DI

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import ggv.ayush.narutoog.data.local.BorutoDatabase
import ggv.ayush.narutoog.util.Constants.BORUTU_DATABASE
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) =
        Room.databaseBuilder(
            context,
             BorutoDatabase::class.java,
            BORUTU_DATABASE
        ).build(
        )
}