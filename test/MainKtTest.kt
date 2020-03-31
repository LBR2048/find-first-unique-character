import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun allUpperCaseWithSingleUniqueChar_find_singleUniqueChar() {
        val word = "MYSUGRISMYSUGR"
        assertEquals('I', word.findFirstUniqueCharacter())
    }

    @Test
    fun allUpperCaseWithSeveralUniqueChar_find_firstUniqueChar() {
        val word = "MYSUGRISMYSUGR!"
        assertEquals('I', word.findFirstUniqueCharacter())
    }

    @Test
    fun mixedUpperCaseWithSeveralUniqueChar_find_firstUniqueChar() {
        val word = "mysugrISMYSUGR!"
        assertEquals('m', word.findFirstUniqueCharacter())
    }

    @Test
    fun allUpperCaseWithoutUniqueChar_find_null() {
        val word = "MYSUGRMYSUGR"
        assertEquals(null, word.findFirstUniqueCharacter())
    }

    @Test
    fun blank_find_null() {
        val word = " "
        assertEquals(null, word.findFirstUniqueCharacter())
    }

    @Test
    fun empty_find_null() {
        val word = ""
        assertEquals(null, word.findFirstUniqueCharacter())
    }

    @Test
    fun multilineBlank_find_null() {
        val word = " \n "
        assertEquals(null, word.findFirstUniqueCharacter())
    }

    @Test
    fun number_find_1() {
        val word = "123"
        assertEquals('1', word.findFirstUniqueCharacter())
    }

    @Test
    fun arrows_find_null() {
        val word = "←↑→↓←↑→↓"
        assertEquals(null, word.findFirstUniqueCharacter())
    }

    @Test
    fun arrows_find_leftArrow() {
        val word = "↑→↓←↑→↓"
        assertEquals('←', word.findFirstUniqueCharacter())
    }
}