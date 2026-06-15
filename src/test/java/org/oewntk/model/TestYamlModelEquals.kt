/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.model

import junit.framework.TestCase.assertTrue
import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.Lex.Companion.lexComparator
import org.oewntk.model.ModelEquals.checkDataEq
import org.oewntk.yaml.`in`.LibTestsYamlCommon.model
import org.oewntk.yaml.`in`.LibTestsYamlCommon.modelB

class TestYamlModelEquals {

    @Test
    fun testModel() {
        assertTrue(model.lexes == modelB.lexes)
        assertTrue(model.synsets == modelB.synsets)
        assertTrue(model.senses == modelB.senses)
        assertTrue(model == modelB)
    }

    @Test
    fun testModelData() {
        val data1 = Triple(model.lexes, model.synsets, model.senses)
        val data2 = Triple(modelB.lexes, modelB.synsets, modelB.senses)
        checkDataEq(data1, data2)
    }

    @Test
    fun testModelSortedData() {
        val data1 = Triple(model.lexes.toSortedSet(lexComparator), model.synsets.toSortedSet(), model.senses.toSortedSet())
        val data2 = Triple(modelB.lexes.toSortedSet(lexComparator), modelB.synsets.toSortedSet(), modelB.senses.toSortedSet())
        checkDataEq(data1, data2)
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
