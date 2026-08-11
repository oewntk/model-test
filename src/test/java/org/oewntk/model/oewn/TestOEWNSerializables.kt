/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.model.oewn

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.*
import org.oewntk.model.Lex.Groups.lexByLemmaThenByKey2
import org.oewntk.model.LibModelSubset.lexSubset
import org.oewntk.model.LibModelSubset.synsetSubset
import org.oewntk.ser.`in`.LibTestsSerCommon.checkOrig
import org.oewntk.ser.`in`.LibTestsSerCommon.model
import org.oewntk.ser.`in`.LibTestsSerCommon.ps

class TestOEWNSerializables {

    @Test
    fun testDummyLex() {
        val lex = Lex("jest", "n", listOf("jest%1:10:00::", "jest%1:04:00::"))
        val serializable: Map<String, Any> = lex.toOEWNDataValue(model.senseResolver)
        ps.println(serializable)
    }

    @Test
    fun testDummySynset() {
        val synset = Synset(
            "77777777-n",
            SynsetType.N,
            "domain",
            setOf("member1", "member2"),
            listOf("definition", "definition2"),
        )
        val serializable: Map<String, Any> = synset.toOEWNDataValue()
        ps.println(serializable)
    }

    @Test
    fun testSense() {
        val sense: Sense = model.senseResolver("jest%1:10:00::")
        val serializable: Map<String, Any> = sense.toOEWNData()
        ps.println(serializable)
    }

    @Test
    fun testSomeSenses() {
        val someSenses: Sequence<Sense> = arrayOf("force%1:07:00::", "force%1:07:01::", "force%1:19:00::")
            .map(model.senseResolver)
            .asSequence()
        val serializables: Sequence<Map<String, Any>> = someSenses.map { it.toOEWNData() }
        ps.println(serializables.joinToString(separator = "\n\n"))
    }

    @Test
    fun testSynset() {
        val synset: Synset = model.synsetResolver("05042508-n")
        val serializable: Map<String, Any> = synset.toOEWNDataValue()
        ps.println(serializable)
    }

    @Test
    fun testSomeSynsets() {
        val someSynsets: Sequence<Synset> = arrayOf("05042508-n", "05201846-n", "11479041-n")
            .map(model.synsetResolver)
            .asSequence()
        val serializables: Sequence<Map<String, Any>> = someSynsets.map { it.toOEWNDataValue() }
        ps.println(serializables.joinToString(separator = "\n\n"))
    }

    @Test
    fun testRandomSynsets() {
        val someSynsets: Sequence<Synset> = model.synsetSubset().asSequence()
        val serializables: Sequence<Map<String, Any>> = someSynsets.map { it.toOEWNDataValue() }
        ps.println(serializables.joinToString("\n\n"))
    }

    @Test
    fun testLex() {
        val lex: Lex = model.lexResolver1("jest", "n")
        val serializable: Map<String, Any> = lex.toOEWNDataValue(model.senseResolver)
        ps.println(serializable)
    }

    @Test
    fun testSomeLexes() {
        val someLexes: Sequence<Lex> = arrayOf("force", "lead", "row", "bow", "galore")
            .flatMap(model.lexResolver)
            .asSequence()
        val serializables: Sequence<Map<String, Any>> = someLexes.map { it.toOEWNDataValue(model.senseResolver) }
        ps.println(serializables.joinToString(separator = "\n\n"))
    }

    @Test
    fun testRandomLexes() {
        val someLexes: Sequence<Lex> = model.lexSubset().asSequence()
        val serializables: Sequence<Map<String, Any>> = someLexes.map { it.toOEWNDataValue(model.senseResolver) }
        ps.println(serializables.joinToString(separator = "\n\n"))
    }

    @Test
    fun testSomeLexesByLemmaThenByKey2() {
        val someLexes: Sequence<Lex> = model.lexSubset(howMany = 5).asSequence()
        val map: HyperMap1 = someLexes.lexByLemmaThenByKey2()
        val serializableMap: Map<Lemma, Any> = map.toOEWNData(model.senseResolver)
        ps.println(serializableMap)
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
