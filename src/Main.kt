/**
 * Returns the first unique character or `null` if no such character is found.
 * Lower and uppercase characters are considered to be different.
 * Whitespaces, line breaks and tabs are not considered valid characters.
 *
 * The time complexity is O(n)
 */
fun CharSequence.findFirstUniqueCharacter(): Char? {

    // Create linked hash map that relates char to its count, keeping insertion order
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