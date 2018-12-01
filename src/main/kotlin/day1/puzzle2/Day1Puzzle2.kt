package day1.puzzle2

import util.Util

fun main() {
    val input = Util.getResourceLines("day1/puzzle1/input").map { it.toInt() }
    // add the starting frequency 0 to the seen set since it might also be the
    // case that this 0 is the first frequency our device reaches twice first
    val startingFrequency = 0
    val seenFrequencies = mutableSetOf(startingFrequency)
    var frequency = startingFrequency
    var i = 0
    // traverse the input as long as necessary
    while (true) {
        frequency += input[i]
        if (seenFrequencies.contains(frequency)) {
            println(frequency)
            break
        } else {
            val inputAdded = seenFrequencies.add(frequency)
            assert(inputAdded)
        }
        i++
        if (i == input.size) {
            i = 0
        }
    }
}