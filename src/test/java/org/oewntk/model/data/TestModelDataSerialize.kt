package org.oewntk.model.data

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.LibModelSubset.lexSubset
import org.oewntk.model.LibModelSubset.senseSubset
import org.oewntk.model.LibModelSubset.synsetSubset
import org.oewntk.model.toData
import org.oewntk.ser.`in`.LibTestsSerCommon.checkOrig
import org.oewntk.ser.`in`.LibTestsSerCommon.model
import org.oewntk.ser.`in`.LibTestsSerCommon.ps

class TestModelDataSerialize {

    @Test
    fun testModelSerialization() {
        val y = model.toData(
            whichLexes = model.lexSubset(howMany = 5).asSequence(),
            whichSynsets = model.synsetSubset(howMany = 5).asSequence(),
            whichSenses = model.senseSubset(howMany = 5).asSequence()
        )
        ps.println(y)
    }

    @Test
    fun testOrig() {
        checkOrig()
    }

    companion object {

        @JvmStatic
        @BeforeClass
        fun init() {
            model
        }
    }
}