package day1.puzzle1

import util.Util

fun main() {
    val input = Util.getResourceLines("day1/puzzle1/input")
    val sum = input.map { it.toInt() }.sum()
    // start frequency is 0 so the result is just the sum
    println(sum)
}
