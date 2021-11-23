package com.example.androidtddmasterclass.acceptancetests


import com.example.androidtddmasterclass.Car
import com.example.androidtddmasterclass.Engine
import com.example.androidtddmasterclass.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Rule
import org.junit.Test


class CarFeature {

    private val engine = Engine(false)
    private val car = Car(engine,6.0)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperatureGradually() {
        car.turnOn()

        coroutinesTestRule.advanceTimeBy(2000)
        assertEquals(25, car.engine.temperature)

        coroutinesTestRule.advanceTimeBy(2000)
        assertEquals(50, car.engine.temperature)

        coroutinesTestRule.advanceTimeBy(1000)
        assertEquals(95, car.engine.temperature)

        assertTrue(car.engine.isTurnedOn)
    }
}