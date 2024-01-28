package com.example.coffeediary.room.model.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.coffeediary.room.model.data.local.CoffeeDao
import com.example.coffeediary.room.model.data.local.CoffeeDatabase
import com.example.coffeediary.room.model.data.repository.CoffeeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideCoffeeRepository(
        coffeeDao : CoffeeDao
    ): CoffeeRepository {
        return CoffeeRepository(dao = coffeeDao)
    }

    @Singleton
    @Provides
    fun provideCoffeeDatabase(app: Application): CoffeeDatabase {
        return CoffeeDatabase.getInstance(context = app)
    }

    @Singleton
    @Provides
    fun provideCoffeeDao(appDatabase: CoffeeDatabase): CoffeeDao {
        return appDatabase.coffeeDao()
    }
}

//@Module
//@InstallIn (SingletonComponent::class)
//object AppModule {
//
//    @Provides
//    @Singleton
//    fun provideLocalDatabase(@ApplicationContext context : Context): CoffeeDatabase {
//        return Room.databaseBuilder(
//            context,
//            CoffeeDatabase::class.java,
//            "local_db"
//        ).build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideCoffeeDao(db: CoffeeDatabase): CoffeeDao = db.coffeeDao()
//
//    @Provides
//    @Singleton
//    fun provideCoffeeRepository(dao : CoffeeDao): CoffeeRepository = CoffeeRepository(dao = dao)
//}