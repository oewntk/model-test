/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.model

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.Lex.Companion.lexComparator
import org.oewntk.model.ModelEquals.checkZipLexesEq
import org.oewntk.model.ModelEquals.checkZipSensesEq
import org.oewntk.model.ModelEquals.checkZipSynsetsEq
import org.oewntk.yaml.`in`.LibTestsYamlCommon.model
import org.oewntk.yaml.`in`.LibTestsYamlCommon.modelB
import kotlin.test.DefaultAsserter.fail

class TestYamlZipModelEquals {

    @Test
    fun testZipLexesModel() {
        val lexes1 = model.lexes.sortedWith(lexComparator)
        val lexes2 = modelB.lexes.sortedWith(lexComparator)
        try {
            checkZipLexesEq(lexes1, lexes2)
        } catch (e: IllegalStateException) {
            fail(e.message)
        }
    }

    @Test
    fun testZipSynsetsModel() {
        val synsets1 = model.synsets.sorted()
        val synsets2 = modelB.synsets.sorted()
        try {
            checkZipSynsetsEq(synsets1, synsets2)
        } catch (e: IllegalStateException) {
            fail(e.message)
        }
    }

    @Test
    fun testZipSensesModel() {
        val senses1 = model.senses.sorted()
        val senses2 = modelB.senses.sorted()
        try {
            checkZipSensesEq(senses1, senses2)
        } catch (e: IllegalStateException) {
            fail(e.message)
        }
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
