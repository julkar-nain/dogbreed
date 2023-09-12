package com.julkar.dogbreed.common

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseCoroutineUseCase<in P, R> {

    suspend operator fun invoke(params: P): R {
        return try {
            withContext(Dispatchers.IO) {
                execute(params)
            }
        } catch (e: Exception) {
            Log.d(this::class.simpleName, e.toString())
            provideDataOnError(e)
        }
    }

    protected abstract suspend fun execute(params: P): R

    protected abstract fun provideDataOnError(error: Exception): R
}