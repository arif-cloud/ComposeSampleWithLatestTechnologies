package com.example.soccerapp.di

import com.example.soccerapp.common.Constants
import com.example.soccerapp.data.remote.SoccerApi
import com.example.soccerapp.data.remote.repository.SoccerRepositoryImpl
import com.example.soccerapp.domain.repository.SoccerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSoccerApi(): SoccerApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SoccerApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSoccerRepository(api: SoccerApi): SoccerRepository {
        return SoccerRepositoryImpl(api)
    }

}