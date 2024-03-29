package com.example.androidtddmasterclass.unittests

import com.example.androidtddmasterclass.Car
import com.example.androidtddmasterclass.Engine
import com.example.androidtddmasterclass.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule


import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class CarShould {
    private val engine: Engine = mock()
    private val car:Car

    init {
        runBlockingTest {
            whenever(engine.turnOn()).thenReturn(flow {
                delay(2000)
                emit(25)
                delay(2000)
                emit(50)
                delay(2000)
                emit(95)
            })
        }

        car = Car(engine, 6.0)
    }

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun loosingFuelWhenItTurnsOn() = runBlockingTest {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runBlockingTest {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}