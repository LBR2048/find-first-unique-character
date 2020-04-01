/**
 * Returns the first unique character or `null` if no such character is found.
 * This solution works with all Unicode characters.
 * Lower and uppercase characters are considered to be different.
 * Whitespaces, line breaks and tabs are not considered valid characters.
 *
 * The time complexity is O(n)
 */
fun CharSequence.findFirstUniqueCharacterSlower(): Char? {

    // Create linked hash map that relates char to its count, keeping insertion order
    val charCountMap = linkedMapOf<Char, Int>()
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

/**
 * Faster alternative for the above function when dealing with larger char sequences
 *
 * The time complexity is O(n)
 */
fun CharSequence.findFirstUniqueCharacter(): Char? {

    // Create linked hash set of unique chars (keeping insertion order) and repeated chars (undefined order)
    val uniqueCharSet = linkedSetOf<Char>()
    val repeatedCharSet = mutableSetOf<Char>()
    forEach {
        if (it.isWhitespace() || repeatedCharSet.contains(it)) return@forEach
        if (uniqueCharSet.contains(it)) {
            uniqueCharSet.remove(it)
            repeatedCharSet.add(it)
        } else {
            uniqueCharSet.add(it)
        }
    }

    // Get the first element from the unique chars set
    with(uniqueCharSet.iterator()) {
        return if (hasNext()) next() else null
    }
}