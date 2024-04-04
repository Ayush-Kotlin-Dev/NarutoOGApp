package ggv.ayush.narutoog.DI

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ggv.ayush.narutoog.data.remote.BorutoApi
import ggv.ayush.narutoog.util.Constants.BASE_URL
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient() : OkHttpClient {
        //the connection timeout is the timeout in making the initial connecton ,
        // and the read timeOut is the timeout on waiting to read the data.


        return OkHttpClient.Builder()
            .readTimeout(15 , TimeUnit.MINUTES)
            .connectTimeout(15,TimeUnit.MINUTES)
            .build()
    }
    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient) :Retrofit{

        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideBorutoApi(retrofit: Retrofit):BorutoApi{
        return retrofit.create(BorutoApi::class.java)
    }
}