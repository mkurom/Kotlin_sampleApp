package com.example.todoapp.module

import com.example.todoapp.repository.ToDoItemRepository
import com.example.todoapp.repository.ToDoItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ToDoRepositoryModule {
    @Singleton
    @Binds
    abstract fun bindToDoRepository(
        impl: ToDoItemRepositoryImpl
    ): ToDoItemRepository
}