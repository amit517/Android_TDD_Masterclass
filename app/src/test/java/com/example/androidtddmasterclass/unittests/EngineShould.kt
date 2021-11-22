package com.example.androidtddmasterclass.unittests

import com.example.androidtddmasterclass.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class EngineShould {

    private val engine = Engine(false,15)
    @Test
    fun turnOn(){
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTheTemperatureWhenItTurnsOn(){
        engine.turnOn()

        assertEquals(95,engine.temperature)
    }
}