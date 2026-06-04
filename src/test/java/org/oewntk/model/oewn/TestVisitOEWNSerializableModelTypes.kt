/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.model.oewn

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.Filename
import org.oewntk.model.LibTestGen.genModelSerializables
import org.oewntk.model.LibVisitSerializableTypes.visit
import org.oewntk.ser.`in`.LibTestsSerCommon.checkOrig
import org.oewntk.ser.`in`.LibTestsSerCommon.model
import org.oewntk.ser.`in`.LibTestsSerCommon.ps

class TestVisitOEWNSerializableModelTypes {

    @Test
    fun testSerializedModel() {
        val serialized: Sequence<Pair<Map<String, Any>, Filename>> = genModelSerializables(model)
        serialized.forEach { (data: Map<String, Any>, _: Filename) ->
            ps.println(data)
            val visited = visit(data)
            ps.println(visited)
        }
    }

    @Test
    fun testOrig() {
        checkOrig()
    }

    companion object {

        @JvmStatic
        @BeforeClass
        fun init() {
            model //eager
        }
    }
}
