package com.example.androidtddmasterclass.unittests

import com.example.androidtddmasterclass.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class EngineShould {

    private val engine = Engine(false,15)
    @Test
    fun turnOn()= runBlockingTest{
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTheTemperatureGraduallyWhenItTurnsOn()= runBlockingTest{
        val flow = engine.turnOn()
        val actual =  flow.toList()

        assertEquals(listOf(25,50,95),actual)
    }
}