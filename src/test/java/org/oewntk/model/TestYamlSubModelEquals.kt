/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.model

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.LibModelEquals.testData
import org.oewntk.model.LibModelEquals.testZipLexes
import org.oewntk.model.LibModelEquals.testZipSenses
import org.oewntk.model.LibModelEquals.testZipSynsets
import org.oewntk.model.LibModelSubset.subset
import org.oewntk.yaml.`in`.LibTestsYamlCommon.model
import org.oewntk.yaml.`in`.LibTestsYamlCommon.modelB

class TestYamlSubModelEquals {

    val from = (1000..10000).random()
    val howMany = 20
    val subModel = model.subset(from = from, howMany = howMany)
    val subModelB = modelB.subset(from = from, howMany = howMany)

    @Test
    fun testSubModelData() {
        testData(subModel, subModelB)
    }

    @Test
    fun testZipLexesSubModel() {
        val (lexes1, _, _) = subModel
        val (lexes2, _, _) = subModelB
        testZipLexes(lexes1, lexes2)
    }

    @Test
    fun testZipSynsetsSubModel() {
        val (_, synsets1, _) = subModel
        val (_, synsets2, _) = subModelB
        testZipSynsets(synsets1, synsets2)
    }

    @Test
    fun testZipSensesSubModel() {
        val (_, _, senses1) = subModel
        val (_, _, senses2) = subModelB
        testZipSenses(senses1, senses2)
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
