package com.saltpay.app.di

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.saltpay.app.common.Constants
import com.saltpay.app.data.local.AppDatabase
import com.saltpay.app.data.remote.dto.SongApi
import com.saltpay.app.data.repository.SongFavRepositoryImpl
import com.saltpay.app.data.repository.SongRepositoryImpl
import com.saltpay.app.domain.repository.SongFavRepository
import com.saltpay.app.domain.repository.SongRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
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
    fun provideSongApi(): SongApi {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(SongApi::class.java)
    }

    @Singleton // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationCompenent (i.e. everywhere in the application)
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        AppDatabase.DB_NAME
    ).build() // The reason we can construct a database for the repo

    @Provides
    @Singleton
    fun provideSongRepository(api: SongApi): SongRepository {
        return SongRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideFavSongRepository(db: AppDatabase): SongFavRepository {
        return SongFavRepositoryImpl(db)
    }
}