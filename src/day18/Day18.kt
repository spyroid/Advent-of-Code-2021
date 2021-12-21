package day18

import readInput
import kotlin.system.measureTimeMillis


fun part1(input: List<String>) = input.size
fun part2(input: List<String>) = input.size

fun main() {

    val testData = readInput("day18/test")
    val inputData = readInput("day18/input")

    check(part1(testData) == 0)

    measureTimeMillis { print("⭐️ Part1: ${part1(inputData)}") }.also { time -> println(" in $time ms") }
    measureTimeMillis { print("⭐️ Part2: ${part2(inputData)}") }.also { time -> println(" in $time ms") }

}

