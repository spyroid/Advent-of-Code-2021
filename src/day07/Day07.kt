package day07

import readIntsAsSeq
import kotlin.math.abs

fun main() {

    fun part1And2(seq: Sequence<Int>, expensiveFuel: Boolean = false): Int {
        val sorted = seq.sorted()
        return (sorted.first()..sorted.last())
            .map { pos ->
                seq.sumOf { current ->
                    if (expensiveFuel) (1..abs(current - pos)).sumOf { it } else abs(current - pos)
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
