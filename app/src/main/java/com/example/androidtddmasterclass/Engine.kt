package com.example.androidtddmasterclass

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Engine(
    var isTurnedOn: Boolean = false,
    var temperature: Int = 15
) {
//    fun turnOnEngine() {
//        this.isEngineTurnOn = true
//    }


    suspend fun turnOn(): Flow<Int> {
        isTurnedOn = true
        return flow {
            delay(2000)
            temperature = 25
            emit(temperature)

            delay(2000)
            temperature = 50
            emit(temperature)

            delay(2000)
            temperature = 95
            emit(temperature)

            Log.d("TAG", "engine turned on: ")
        }
    }
}