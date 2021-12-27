package day18

import readInput
import kotlin.system.measureTimeMillis

data class Node(var value: Int? = null, var left: Node? = null, var right: Node? = null) {
    override fun toString(): String = if (value != null) value.toString() else "[$left,$right]"
}

fun parseLine(line: String): Node {
    var idx = 0
    fun parse(): Node {
        if (line[idx] == '[') {
            idx++
            val l = parse()
            idx++ // ,
            val r = parse()
            idx++ // ]
            return Node(null, l, r)
        }
        val start = idx
        while (line[idx] in '0'..'9') idx++
        return Node(line.substring(start, idx).toInt())
    }
    return parse()
}

fun main() {
    val input = readInput("day18/test")

    var root: Node? = null
    for (line in input) {
        if (root == null) {
            root = parseLine(line)
            continue
        }
        root = Node(null, root, parseLine(line))


    }

//    check(part1(testData) == 0)
//
//    measureTimeMillis { print("⭐️ Part1: ${part1(inputData)}") }.also { time -> println(" in $time ms") }
//    measureTimeMillis { print("⭐️ Part2: ${part2(inputData)}") }.also { time -> println(" in $time ms") }

}

