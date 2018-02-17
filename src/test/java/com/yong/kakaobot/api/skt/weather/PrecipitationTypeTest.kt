package com.yong.kakaobot.api.skt.weather

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*

import org.junit.Test

class PrecipitationTypeTest {

    @Test
    fun of() {
        val none: PrecipitationType = PrecipitationType.of("0")

        assertThat(none, `is`(PrecipitationType.NONE))

        val rain: PrecipitationType = PrecipitationType.of("1")

        assertThat(rain, `is`(PrecipitationType.RAIN))

        val rainSnow: PrecipitationType = PrecipitationType.of("2")

        assertThat(rainSnow, `is`(PrecipitationType.RAIN_SNOW))

        val snow: PrecipitationType = PrecipitationType.of("3")

        assertThat(snow, `is`(PrecipitationType.SNOW))

        val error: PrecipitationType = PrecipitationType.of("")

        assertThat(error, `is`(PrecipitationType.NONE))
    }
}