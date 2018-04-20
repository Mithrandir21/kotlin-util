package it.czerwinski.kotlin.util

import org.junit.Assert.*
import org.junit.Test

class NoneTest {

    @Test
    @Throws(Exception::class)
    fun shouldBeEmpty() {
        // given:
        val option: Option<String> = None
        // when:
        val result = option.isEmpty
        // then:
        assertTrue(result)
    }

    @Test
    @Throws(Exception::class)
    fun shouldNotBeDefined() {
        // given:
        val option: Option<String> = None
        // when:
        val result = option.isDefined
        // then:
        assertFalse(result)
    }

    @Test(expected = NoSuchElementException::class)
    @Throws(Exception::class)
    fun getShouldThrowException() {
        // given:
        val option: Option<String> = None
        // when:
        option.get()
    }

    @Test
    @Throws(Exception::class)
    fun getOrNullShouldReturnNull() {
        // given:
        val option: Option<String> = None
        // when:
        val result = option.getOrNull()
        // then:
        assertNull(result)
    }

    @Test
    @Throws(Exception::class)
    fun getOrElseShouldReturnDefaultValue() {
        // given:
        val option: Option<String> = None
        // when:
        val result = option.getOrElse { "default" }
        // then:
        assertEquals("default", result)
    }

    @Test
    @Throws(Exception::class)
    fun orElseShouldReturnDefaultOption() {
        // given:
        val option: Option<String> = None
        // when:
        val result = option.orElse { Some("default") }
        // then:
        assertEquals(Some("default"), result)
    }
}