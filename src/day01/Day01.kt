package day01

import readToIntSeq

fun main() {

    fun part1(seq: Sequence<Int>) = seq.windowed(2, 1).sumOf { if (it[1] > it[0]) 1L else 0L }

    fun part2(seq: Sequence<Int>) = part1(seq.windowed(3, 1).map { it.sum() })

    val testSeq = readToIntSeq("day01/test")
    check(part1(testSeq) == 7L)
    check(part2(testSeq) == 5L)

    println("--------------------------------")
    val seq = readToIntSeq("day01/input")
    println(part1(seq))
    println(part2(seq))
}
