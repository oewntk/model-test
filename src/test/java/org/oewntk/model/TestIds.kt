/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.model

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.ser.`in`.LibTestsSerCommon.checkOrig
import org.oewntk.ser.`in`.LibTestsSerCommon.model
import kotlin.test.assertTrue

class TestIds {

    @Test
    fun testLemmas() {
        model.lemmas
            .forEach {
                assert(it.form.isLemma()) { println(it) }
            }
    }

    @Test
    fun testSynsetIds() {
        model.synsets
            .forEach {
                assert(it.synsetId.id.isSynsetId()) { println(it) }
            }
    }

    @Test
    fun testSenseIds() {
        model.senses
            .forEach {
                assert(it.senseId.id.isSenseKey()) { println(it) }
            }
    }

    @Test
    fun testSynsetRelationTargets() {
        model.synsets
            .forEach {
                it.flatRelations?.forEach { (_, targetId) ->
                    assert(targetId.id.isSynsetId() || targetId.id.isSenseKey()) { println(it) }
                }
            }
    }

    @Test
    fun testSenseRelationTargets() {
        model.senses
            .forEach {
                it.flatRelations?.forEach { (_, targetId) ->
                    assertTrue(targetId.id.isSynsetId() || targetId.id.isSenseKey())
                }
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
            model // eager
        }
    }
}
