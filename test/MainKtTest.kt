import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun allUpperCaseWithSingleUniqueChar_find_singleUniqueChar() {
        assertEquals('I', "MYSUGRISMYSUGR".findFirstUniqueCharacter())
    }

    @Test
    fun allUpperCaseWithSeveralUniqueChar_find_firstUniqueChar() {
        assertEquals('I', "MYSUGRISMYSUGR!".findFirstUniqueCharacter())
    }

    @Test
    fun mixedUpperCaseWithSeveralUniqueChar_find_firstUniqueChar() {
        assertEquals('m', "mysugrISMYSUGR!".findFirstUniqueCharacter())
    }

    @Test
    fun allUpperCaseWithoutUniqueChar_find_null() {
        assertEquals(null, "MYSUGRMYSUGR".findFirstUniqueCharacter())
    }

    @Test
    fun blank_find_null() {
        assertEquals(null, " ".findFirstUniqueCharacter())
    }

    @Test
    fun empty_find_null() {
        assertEquals(null, "".findFirstUniqueCharacter())
    }

    @Test
    fun multilineBlank_find_null() {
        assertEquals(null, " \n ".findFirstUniqueCharacter())
    }

    @Test
    fun number_find_1() {
        assertEquals('1', "123".findFirstUniqueCharacter())
    }

    @Test
    fun arrows_find_null() {
        assertEquals(null, "←↑→↓←↑→↓".findFirstUniqueCharacter())
    }

    @Test
    fun arrows_find_leftArrow() {
        assertEquals('←', "↑→↓←↑→↓".findFirstUniqueCharacter())
    }
}