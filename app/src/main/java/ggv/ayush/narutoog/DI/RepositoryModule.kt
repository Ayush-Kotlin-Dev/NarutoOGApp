package ggv.ayush.narutoog.DI

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import ggv.ayush.narutoog.data.pref.DataStoreOperationImpl
import ggv.ayush.narutoog.domain.repository.DataStoreOperations
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        context: Context
    ) : DataStoreOperations {
        return DataStoreOperationImpl(context = context )
    }
}