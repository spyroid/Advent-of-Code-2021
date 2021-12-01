package day02

import readToIntSeq

fun main() {

    fun part1(seq: Sequence<Int>): Long {
        return 0
    }

    fun part2(seq: Sequence<Int>): Long {
        return 0
    }

    val testSeq = readToIntSeq("day02/test")
    check(part1(testSeq) == 7L)
    check(part2(testSeq) == 5L)

    println("--------------------------------")
    val seq = readToIntSeq("day02/input")
    println(part1(seq))
    println(part2(seq))
}
