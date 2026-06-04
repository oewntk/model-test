/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.model.data

import org.junit.BeforeClass
import org.junit.Test
import org.oewntk.model.HyperMap1
import org.oewntk.model.Lemma
import org.oewntk.model.Lex
import org.oewntk.model.Lex.Groups.lexByLemmaThenByKey2
import org.oewntk.model.LibModelSubset.lexSubset
import org.oewntk.model.LibModelSubset.synsetSubset
import org.oewntk.model.LibVisitSerializableTypes.visit
import org.oewntk.model.Sense
import org.oewntk.model.Synset
import org.oewntk.model.toData
import org.oewntk.ser.`in`.LibTestsSerCommon.checkOrig
import org.oewntk.ser.`in`.LibTestsSerCommon.model
import org.oewntk.ser.`in`.LibTestsSerCommon.ps
import kotlin.collections.List

class TestVisitDataSerializableTypes {

    @Test
    fun testSense() {
        val sense: Sense = model.senseResolver("jest%1:10:00::")
        val serializable: Map<String, Any> = sense.toData()
        ps.println(serializable)
        val visited = visit(serializable)
        ps.println(visited)
    }

    @Test
    fun testSomeSenses() {
        val someSenses: Sequence<Sense> = arrayOf("force%1:07:00::", "force%1:07:01::", "force%1:19:00::")
            .map(model.senseResolver)
            .asSequence()
        val serializables: List<Map<String, Any>> = someSenses.map { it.toData() }.toList()
        ps.println(serializables.joinToString(separator = "\n\n"))
        val visited = serializables.map { visit(it) }
        ps.println(visited)
    }

    @Test
    fun testSynset() {
        val synset: Synset = model.synsetResolver("05042508-n")
        val serializable: Map<String, Any> = synset.toData()
        ps.println(serializable)
        val visited = visit(serializable)
        ps.println(visited)
    }

    @Test
    fun testSomeSynsets() {
        val someSynsets: Sequence<Synset> = arrayOf("05042508-n", "05201846-n", "11479041-n")
            .map(model.synsetResolver)
            .asSequence()
        val serializables: List<Map<String, Any>> = someSynsets.map { it.toData() }.toList()
        ps.println(serializables.joinToString(separator = "\n\n"))
        val visited = serializables.map { visit(it) }
        ps.println(visited)
    }

    @Test
    fun testRandomSynsets() {
        val someSynsets: Sequence<Synset> = model.synsetSubset()
        val serializables: List<Map<String, Any>> = someSynsets.map { it.toData() }.toList()
        ps.println(serializables.joinToString("\n\n"))
        val visited = serializables.map { visit(it) }
        ps.println(visited)
     }

    @Test
    fun testLex() {
        val lex: Lex = model.lexResolver1("jest", "n")
        val serializable: Map<String, Any> = lex.toData()
        ps.println(serializable)
        val visited = visit(serializable)
        ps.println(visited)
    }

    @Test
    fun testSomeLexes() {
        val someLexes: Sequence<Lex> = arrayOf("force", "lead", "row", "bow", "galore")
            .flatMap(model.lexResolver)
            .asSequence()
        val serializables: List<Map<String, Any>> = someLexes.map { it.toData() }.toList()
        ps.println(serializables.joinToString(separator = "\n\n"))
        val visited = serializables.map { visit(it) }
        ps.println(visited)
    }

    @Test
    fun testRandomLexes() {
        val someLexes: Sequence<Lex> = model.lexSubset()
        val serializables: List<Map<String, Any>> = someLexes.map { it.toData() }.toList()
        ps.println(serializables.joinToString(separator = "\n\n"))
        val visited = serializables.map { visit(it) }
        ps.println(visited)
    }

    //@Test
    //fun testSomeLexesByLemmaThenByKey2() {
    //    val someLexes: Sequence<Lex> = model.lexSubset(howMany = 5)
    //    val map: HyperMap1 = someLexes.lexByLemmaThenByKey2()
    //    val serializableMap: Map<Lemma, Any> = map.toData()
    //    ps.println(serializableMap)
    //    val visited = visit(serializableMap)
    //    ps.println(visited)
    //}

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
