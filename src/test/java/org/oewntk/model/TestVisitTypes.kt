/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.model

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.LibTestGen.genDummyMap
import org.oewntk.model.LibVisitTypes.visit
import org.oewntk.ser.`in`.LibTestsSerCommon.ps

class TestVisitTypes {

    val m = genDummyMap()
    val m2 = visit(m)

    @Test
    fun testMap() {
        val s = m.toString()
        ps.println(s)
    }

    @Test
    fun testVisitedMap() {
        val s = m2.toString()
        ps.println(s)
    }

    companion object {

        @JvmStatic
        @BeforeClass
        fun init() {
        }
    }
}
