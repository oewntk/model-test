/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.model

import junit.framework.TestCase.assertTrue
import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.LibModelSubset.subset
import org.oewntk.ser.`in`.LibTestsSerCommon.checkOrig
import org.oewntk.ser.`in`.LibTestsSerCommon.model
import org.oewntk.ser.`in`.LibTestsSerCommon.modelB

class TestSerModelEquals {

    @Test
    fun testModel() {
        val from = (1000..10000).random()
        val howMany = 20
        val (lexes1, senses1, synsets1) = model.subset(from=from, howMany=howMany)
        val (lexes2, senses2, synsets2) = modelB.subset(from=from, howMany=howMany)
        assertTrue( lexes1.toSet() == lexes2.toSet())
        assertTrue( senses1.toSet() == senses2.toSet())
        assertTrue( synsets1.toSet() == synsets2.toSet())
    }

    @Test
    fun testOrig() {
        checkOrig()
    }

    companion object {

        @JvmStatic
        @BeforeClass
        fun init() {
            model // eager
            modelB // eager
        }
    }
}
