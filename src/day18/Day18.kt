package day18

import readInput
import kotlin.system.measureTimeMillis

data class Node(var value: Int? = null, var left: Node? = null, var right: Node? = null) {
    fun find3th(): Node? {
        fun deeper(level: Int, node: Node?): Node? {
            if (level == 3 || node == null) return node
            return deeper(level + 1, node)
        }
        var level = 0
        val l = deeper(1, left)
        val r = deeper(1, right)
        return null
    }
}

fun main() {

    fun part1(input: List<String>): Int {

        val root = Node(null, Node(1), Node(2))

        return 0
    }

    fun part2(input: List<String>) = input.size


    val testData = readInput("day18/test")
    val inputData = readInput("day18/input")

    check(part1(testData) == 0)

    measureTimeMillis { print("⭐️ Part1: ${part1(inputData)}") }.also { time -> println(" in $time ms") }
    measureTimeMillis { print("⭐️ Part2: ${part2(inputData)}") }.also { time -> println(" in $time ms") }

}

