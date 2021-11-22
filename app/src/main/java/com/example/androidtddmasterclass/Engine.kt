package com.example.androidtddmasterclass

class Engine(
    var isTurnedOn: Boolean = false,
    var temperature: Int = 15
) {
//    fun turnOnEngine() {
//        this.isEngineTurnOn = true
//    }


    fun turnOn() {
        isTurnedOn = true
        temperature = 95
    }
}