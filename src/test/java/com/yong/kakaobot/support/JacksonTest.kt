package com.yong.kakaobot.support

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import junit.framework.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class JacksonTest: Spek({
    class Person(val name:String, val age:Int)

    describe("jackson"){
        val objectMapper:ObjectMapper = jacksonObjectMapper()

        it("serialize") {
            val json: String = objectMapper.writeValueAsString(Person("changyong", 30))

            val expected: String = "{\"name\":\"changyong\",\"age\":30}"
            assertEquals(expected, json)
        }
    }
})