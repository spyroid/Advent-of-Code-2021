package day02

import readInput

fun main() {

    data class Command(val op: String, val value: Int)

    fun part1(seq: Sequence<Command>): Int {
        var depth = 0
        var horizontal = 0
        seq.forEach {
            when (it.op) {
                "forward" -> horizontal += it.value
                "down" -> depth += it.value
                "up" -> depth -= it.value
            }
        }
        return depth * horizontal
    }

    fun part2(seq: Sequence<Command>): Int {
        var depth = 0
        var horizontal = 0
        var aim = 0
        seq.forEach {
            when (it.op) {
                "forward" -> {
                    horizontal += it.value
                    depth += it.value * aim
                }
                "down" -> aim += it.value
                "up" -> aim -= it.value
            }
        }
        return depth * horizontal
    }

    fun mapCommand(str: String): Command {
        val parts = str.split(" ")
        return Command(parts[0], parts[1].toInt())
    }

    val testSeq = readInput("day02/test").asSequence().map { mapCommand(it) }
    val seq = readInput("day02/input").asSequence().map { mapCommand(it) }

    val res1 = part1(testSeq)
    check(res1 == 150) { "Expected 150 but got $res1" }
    println("Part1: " + part1(seq))

    val res2 = part2(testSeq)
    check(res2 == 900) { "Expected 900 but got $res2" }
    println("Part2: " + part2(seq))
}
