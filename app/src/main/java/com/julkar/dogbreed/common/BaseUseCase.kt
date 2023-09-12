package com.julkar.dogbreed.common

import android.util.Log

abstract class BaseUseCase<in P, R> {

    operator fun invoke(params: P): R {
        return try {
            execute(params)
        } catch (e: Exception) {
            Log.d(this::class.simpleName, e.toString())
            provideDataOnError(e)
        }
    }

    protected abstract fun execute(params: P): R

    protected abstract fun provideDataOnError(error: Exception): R
}