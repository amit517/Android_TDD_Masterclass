package com.example.androidtddmasterclass

import android.util.Log
import kotlinx.coroutines.delay

class Engine(
    var isTurnedOn: Boolean = false,
    var temperature: Int = 15
) {
//    fun turnOnEngine() {
//        this.isEngineTurnOn = true
//    }


    suspend fun turnOn() {
        isTurnedOn = true
        delay(6000)
        temperature = 95
    }
}