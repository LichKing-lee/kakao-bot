package com.yong.kakaobot.support

import junit.framework.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Ignore
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.util.*

@Ignore
class DateParseTest: Spek({
    describe("parse test") {
        val target: String = "Sun, 04 Feb 2018 16:31:56 +0900"

        it("date test") {
            val date: Date = Date(target)

            assertEquals(1, date.month)
            assertEquals(4, date.date)
        }

        it("calendar test") {
            val date: Calendar = Calendar.getInstance()
            date.time = Date(target)

            assertEquals(1, date.get(Calendar.MONTH))
            assertEquals(4, date.get(Calendar.DATE))
        }

        it("local date time test") {
            val date: LocalDateTime = LocalDateTime.ofInstant(Date(target).toInstant(), ZoneId.systemDefault())

            assertEquals(2, date.month.value)
            assertEquals(4, date.dayOfMonth)
            assertEquals(LocalTime.of(16, 31, 56), date.toLocalTime())
        }

        it("random") {
            println(Random().nextInt(3))
        }
    }
})