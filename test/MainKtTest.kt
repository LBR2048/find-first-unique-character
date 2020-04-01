import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun `when all uppercase letters with a single unique element expect that element`() {
        assertEquals('I', "MYSUGRISMYSUGR".findFirstUniqueCharacter())
    }

    @Test
    fun `when all uppercase letters with several unique elements expect the first unique element`() {
        assertEquals('I', "MYSUGRISMYSUGR!".findFirstUniqueCharacter())
    }

    @Test
    fun `when lower and uppercase letters with several unique elements expect the first unique element`() {
        assertEquals('m', "mysugrISMYSUGR!".findFirstUniqueCharacter())
    }

    @Test
    fun `when all capital letters without unique element expect null`() {
        assertEquals(null, "MYSUGRMYSUGR".findFirstUniqueCharacter())
    }

    @Test
    fun `when blank string expect null`() {
        assertEquals(null, " ".findFirstUniqueCharacter())
    }

    @Test
    fun `when empty string expect null`() {
        assertEquals(null, "".findFirstUniqueCharacter())
    }

    @Test
    fun `when multiline empty string expect null`() {
        assertEquals(null, " \n ".findFirstUniqueCharacter())
    }

    @Test
    fun `when special characters without unique elements expect null`() {
        assertEquals(null, "←↑→↓←↑→↓".findFirstUniqueCharacter())
    }

    @Test
    fun `large char sequence with unique elements expect first unique element`() {
        val uniqueChar1 = 40001.toChar()
        val uniqueChar2 = 40002.toChar()
        val uniqueChar3 = 40003.toChar()
        val repeatedChars = (0..40000).map { it.toChar() }.joinToString(separator = "").repeat(1000)
        assertEquals(uniqueChar1, (repeatedChars + uniqueChar1 + uniqueChar2 + repeatedChars + uniqueChar3).findFirstUniqueCharacter())
    }
}