package day2.puzzle2

import util.Util
import util.combinations

fun main() {
    val input = Util.getResourceLines("day2/puzzle1/input")
    val only1Diff = input.combinations(2)
        .associate { Pair(it, getDiffs(it[0], it[1])) }
        .filterValues { it.size == 1 }
        .mapValues { it.value.first() }
        .toList()
    assert(only1Diff.size == 1)
    val (ids: List<String>, diffIndex: Int) = only1Diff.first()
    // does not matter which of the two IDs to take, so just use the first
    println(ids.first().removeCharAt(diffIndex))
}

fun getDiffs(id1: String, id2: String): List<Int> {
    assert(id1.length == id2.length)
    val diffs = mutableListOf<Int>()
    for (i in id1.indices) {
        if (id1[i] != id2[i]) {
            diffs.add(i)
        }
    }
    return diffs
}

// just for syntactic sugar since "index..index" is not that nice
fun String.removeCharAt(index: Int) = this.removeRange(index..index)