/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.model

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.Lex.Companion.lexComparator
import org.oewntk.model.LibModelEquals.testZipLexes
import org.oewntk.model.LibModelEquals.testZipSenses
import org.oewntk.model.LibModelEquals.testZipSynsets
import org.oewntk.yaml.`in`.LibTestsYamlCommon.model
import org.oewntk.yaml.`in`.LibTestsYamlCommon.modelB

class TestYamlZipModelEquals {

    @Test
    fun testZipLexesModel() {
        val lexes1 = model.lexes.toSortedSet(lexComparator)
        val lexes2 = modelB.lexes.toSortedSet(lexComparator)
        testZipLexes(lexes1, lexes2)
    }

    @Test
    fun testZipSynsetsModel() {
        val synsets1 = model.synsets.toSortedSet()
        val synsets2 = modelB.synsets.toSortedSet()
        testZipSynsets(synsets1, synsets2)
    }

    @Test
    fun testZipSensesModel() {
        val senses1 = model.senses.toSortedSet()
        val senses2 = modelB.senses.toSortedSet()
        testZipSenses(senses1, senses2)
    }

    companion object {

        const val FAIL = true

        @JvmStatic
        @BeforeClass
        fun init() {
            model // eager
            modelB // eager
        }
    }
}
