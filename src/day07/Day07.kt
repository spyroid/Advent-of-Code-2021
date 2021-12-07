package day07

import readIntsAsSeq
import kotlin.math.abs

fun main() {

    fun part1And2(seq: Sequence<Int>, expensiveFuel: Boolean = false): Int {
        return seq.sorted().let { (it.first()..it.last()) }
            .map { pos ->
                seq.sumOf { current ->
                    if (expensiveFuel) (abs(current - pos) * (abs(current - pos) + 1)) / 2 else abs(current - pos)
                }
            }
            .minOf { it }
    }

    val testSeq = readIntsAsSeq("day07/test")
    val inputSeq = readIntsAsSeq("day07/input")

    val res1 = part1And2(testSeq)
    check(res1 == 37) { "Expected 37 but got $res1" }
    println("Part1: ${part1And2(inputSeq)}")
    println("Part2: ${part1And2(inputSeq, true)}")
}
