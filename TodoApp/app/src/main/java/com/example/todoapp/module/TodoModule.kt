package com.example.todoapp.module

import android.content.Context
import androidx.room.Room
import com.example.todoapp.database.ToDoDatabase
import com.example.todoapp.interfaceDAO.TodoItemDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ToDoModule {
    @Singleton
    @Provides
    fun provideToDoDatabase(
        @ApplicationContext context: Context
    ): ToDoDatabase {
        return Room.databaseBuilder(
            context,
            ToDoDatabase::class.java,
            "todo.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideToDoDAO(db: ToDoDatabase): TodoItemDAO {
        return db.todoDAO()
    }
}