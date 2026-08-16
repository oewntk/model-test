/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.model.equal

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.ModelEquals.checkDataEq
import org.oewntk.model.ModelEquals.checkZipLexesEq
import org.oewntk.model.ModelEquals.checkZipSensesEq
import org.oewntk.model.ModelEquals.checkZipSynsetsEq
import org.oewntk.model.LibModelSubset.subset
import org.oewntk.yaml.`in`.LibTestsYamlCommon.model
import org.oewntk.yaml.`in`.LibTestsYamlCommon.modelB
import kotlin.test.DefaultAsserter.fail

class TestYamlSubModelEquals {

    val from = (1000..10000).random()
    val howMany = 20
    val subModel = model.subset(from = from, howMany = howMany)
    val subModelB = modelB.subset(from = from, howMany = howMany)

    @Test
    fun testSubModelData() {
        checkDataEq(subModel, subModelB)
    }

    @Test
    fun testZipLexesSubModel() {
        val (lexes1, _, _) = subModel
        val (lexes2, _, _) = subModelB
        try {
            checkZipLexesEq(lexes1, lexes2)
        } catch (e: IllegalStateException) {
            fail(e.message)
        }
    }

    @Test
    fun testZipSynsetsSubModel() {
        val (_, synsets1, _) = subModel
        val (_, synsets2, _) = subModelB
        try {
            checkZipSynsetsEq(synsets1, synsets2)
        } catch (e: IllegalStateException) {
            fail(e.message)
        }
    }

    @Test
    fun testZipSensesSubModel() {
        val (_, _, senses1) = subModel
        val (_, _, senses2) = subModelB
        try {
            checkZipSensesEq(senses1, senses2)
        } catch (e: IllegalStateException) {
            fail(e.message)
        }
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
