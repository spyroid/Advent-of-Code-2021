package day21

import readInput
import kotlin.system.measureTimeMillis

fun part1(input: List<String>) = input.size
fun part2(input: List<String>) = input.size

fun main() {

    val testData = readInput("day21/test")
    val inputData = readInput("day21/input")

    check(part1(testData) == 0)

    measureTimeMillis { print("⭐️ Part1: ${part1(inputData)}") }.also { time -> println(" in $time ms") }
    measureTimeMillis { print("⭐️ Part2: ${part2(inputData)}") }.also { time -> println(" in $time ms") }

}

