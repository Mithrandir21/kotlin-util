package it.czerwinski.kotlin.util

import org.junit.Assert.*
import org.junit.Test

class SomeTest {

    @Test(expected = IllegalArgumentException::class)
    @Throws(Exception::class)
    fun shouldFailToCreateSomeWithNull() {
        // given:
        val value = null
        // when:
        @Suppress("UNUSED_VARIABLE")
        val some: Option<String?> = Some(value)
    }

    @Test
    @Throws(Exception::class)
    fun shouldBeDefined() {
        // given:
        val option: Option<String> = Some("text")
        // when:
        val result = option.isDefined
        // then:
        assertTrue(result)
    }

    @Test
    @Throws(Exception::class)
    fun shouldNotBeEmpty() {
        // given:
        val option: Option<String> = Some("text")
        // when:
        val result = option.isEmpty
        // then:
        assertFalse(result)
    }

    @Test
    @Throws(Exception::class)
    fun getShouldReturnValue() {
        // given:
        val option: Option<String> = Some("text")
        // when:
        val result = option.get()
        // then:
        assertEquals("text", result)
    }

    @Test
    @Throws(Exception::class)
    fun getOrNullShouldReturnValue() {
        // given:
        val option: Option<String> = Some("text")
        // when:
        val result = option.getOrNull()
        // then:
        assertEquals("text", result)
    }

    @Test
    @Throws(Exception::class)
    fun getOrElseShouldReturnValue() {
        // given:
        val option: Option<String> = Some("text")
        // when:
        val result = option.getOrElse { "default" }
        // then:
        assertEquals("text", result)
    }

    @Test
    @Throws(Exception::class)
    fun orElseShouldReturnThis() {
        // given:
        val option: Option<String> = Some("text")
        // when:
        val result = option.orElse { Some("default") }
        // then:
        assertEquals(Some("text"), result)
    }

    @Test
    @Throws(Exception::class)
    fun mapShouldReturnNewSome() {
        // given:
        val option: Option<Int> = Some(123)
        // when:
        val result: Option<String> = option.map { it.toString() }
        // then:
        assertEquals(Some("123"), result)
    }

    @Test
    @Throws(Exception::class)
    fun flatMapShouldReturnNewSome() {
        // given:
        val option: Option<Int> = Some(123)
        // when:
        val result: Option<String> = option.flatMap { Option(it.toString()) }
        // then:
        assertEquals(Some("123"), result)
    }

    @Test
    @Throws(Exception::class)
    fun flatMapShouldReturnNone() {
        // given:
        val option: Option<Int> = Some(123)
        // when:
        val result: Option<String> = option.flatMap { None }
        // then:
        assertEquals(None, result)
    }

    @Test
    @Throws(Exception::class)
    fun flattenShouldReturnInnerSome() {
        // given:
        val option: Option<Option<String>> = Some(Some("text"))
        // when:
        val result: Option<String> = option.flatten()
        // then:
        assertEquals(Some("text"), result)
    }

    @Test
    @Throws(Exception::class)
    fun flattenShouldReturnInnerNone() {
        // given:
        val option: Option<Option<String>> = Some(None)
        // when:
        val result: Option<String> = option.flatten()
        // then:
        assertEquals(None, result)
    }

    @Test
    @Throws(Exception::class)
    fun filterShouldReturnTheSameSomeIfPredicateIsTrue() {
        // given:
        val option: Option<Int> = Some(1)
        // when:
        val result = option.filter { it > 0 }
        // then:
        assertEquals(option, result)
    }

    @Test
    @Throws(Exception::class)
    fun filterShouldReturnNoneIfPredicateIsFalse() {
        // given:
        val option: Option<Int> = Some(-1)
        // when:
        val result = option.filter { it > 0 }
        // then:
        assertEquals(None, result)
    }

    @Test
    @Throws(Exception::class)
    fun filterNotShouldReturnTheSameSomeIfPredicateIsFalse() {
        // given:
        val option: Option<Int> = Some(-1)
        // when:
        val result = option.filterNot { it > 0 }
        // then:
        assertEquals(option, result)
    }

    @Test
    @Throws(Exception::class)
    fun filterNotShouldReturnNoneIfPredicateIsTrue() {
        // given:
        val option: Option<Int> = Some(1)
        // when:
        val result = option.filterNot { it > 0 }
        // then:
        assertEquals(None, result)
    }
}
