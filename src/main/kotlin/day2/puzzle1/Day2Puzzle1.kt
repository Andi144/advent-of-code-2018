package day2.puzzle1

import util.Util

fun main() {
    val input = Util.getResourceLines("day2/puzzle1/input")
    input.map { it }
    val twoLettersCount = countLetters(input, 2)
    val threeLettersCount = countLetters(input, 3)
    println(twoLettersCount * threeLettersCount)
}

fun countLetters(listOfIds: List<String>, occurrences: Int): Int {
    return listOfIds.map { id -> id.groupBy { it }.filterValues { it.size == occurrences } }
        .filter { it.values.isNotEmpty() }
        .count()
}