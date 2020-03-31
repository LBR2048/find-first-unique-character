/**
 * Returns the first unique character or `null` if no such character is found.
 * Lower and uppercase characters are considered to be different.
 * Whitespaces, line breaks and tabs are not considered valid characters.
 *
 * This solution is possibly slower than using an array of bins for each character,
 * but has the advantage of working with all Unicode characters without the need
 * to specify a bin for each one of them.
 * For uses such as DNA sequence analysis, which has only 4 different letters,
 * a bin-based approach is probably faster.
 */
fun CharSequence.findFirstUniqueCharacter(): Char? {

    // Create LinkedHashMap that relates char to its count, keeping insertion order
    val charCountMap = linkedMapOf<Char, Int>().toMutableMap()
    forEach {
        if (it.isWhitespace()) return@forEach
        charCountMap[it] = (charCountMap[it] ?: 0) + 1
    }

    // Search the linked hash map to find the first unique char
    charCountMap.forEach {
        if (it.value == 1) return it.key
    }
    return null
}