package day07

import kotlinx.coroutines.runBlocking
import readIntsAsSeq
import kotlin.math.abs
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    fun part1And2(seq: Sequence<Int>, expensiveFuel: Boolean = false): Int {
        return seq
            .sorted()
            .let { (it.first()..it.last()) }
            .map { pos ->
                seq
                    .map { abs(it - pos) }
                    .sumOf { current ->
                        if (expensiveFuel) (current * (current + 1)) / 2 else current
                    }
            }
            .minOf { it }
    }

    val testSeq = readIntsAsSeq("day07/test")
    val inputSeq = readIntsAsSeq("day07/input")

    var res1 = part1And2(testSeq)
    check(res1 == 37) { "Expected 37 but got $res1" }
    var time = measureTimeMillis { res1 = part1And2(inputSeq) }
    println("Part1: $res1 in $time ms")
    time = measureTimeMillis { res1 = part1And2(inputSeq, true) }
    println("Part1: $res1 in $time ms")
}
