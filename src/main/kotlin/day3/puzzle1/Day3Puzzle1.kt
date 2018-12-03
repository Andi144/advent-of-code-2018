package day3.puzzle1

import util.Util

fun main() {
    val input = Util.getResourceLines("day3/puzzle1/input")
    val claims = input.map { Claim.fromString(it) }
    val maxX = claims.maxBy { it.x2 }!!.x2
    val maxY = claims.maxBy { it.y2 }!!.y2
    val fabric = Fabric(maxX, maxY)
    claims.forEach { fabric.addClaim(it) }
    // the it.asList() call is a bit dumb but Kotlin does not count IntArrays as Iterable
    val commonSquareInches = fabric.data.flatMap { it.asList() }.filter { it >= 2 }.count()
    println(commonSquareInches)
}

class Claim(val x1: Int, val y1: Int, width: Int, height: Int) {
    val x2 = x1 + width - 1
    val y2 = y1 + height - 1

    companion object {
        fun fromString(s: String): Claim {
            // skip id and the @ character
            val (_, _, xy, widthHeight) = s.split(" ").map { it.trim() }
            val (x, y) = xy.removeLastChar().split(",")
            val (width, height) = widthHeight.split("x")
            return Claim(x.toInt(), y.toInt(), width.toInt(), height.toInt())
        }
    }
}

class Fabric(x2: Int, y2: Int) {
    val data = Array(y2 + 1) { IntArray(x2 + 1) }
    fun addClaim(claim: Claim) {
        for (y in claim.y1..claim.y2) {
            for (x in claim.x1..claim.x2) {
                data[y][x] += 1
            }
        }
    }
}

fun String.removeLastChar(): String {
    return substring(0, length - 1)
}