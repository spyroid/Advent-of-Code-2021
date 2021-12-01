package day01

import readInput
import strToIntSeq

fun main() {

    fun doCount(seq: Sequence<Int>): Int {
        var marker = Int.MAX_VALUE
        return seq.map {
            val res = if (it > marker) 1 else 0
            marker = it
            return@map res
        }.sum()
    }

    fun part1(input: List<String>): Int {
        return doCount(strToIntSeq(input))
    }

    fun part2(input: List<String>): Int {
        val seq = IntRange(0, input.size -3).asSequence()
            .map { input[it].toInt() + input[it + 1].toInt() + input[it + 2].toInt() }

        return doCount(seq)
    }

    check(part1(readInput("day01/test01")) == 7)
    check(part2(readInput("day01/test01")) == 5)

    println("--------------------------------")
    println(part1(readInput("day01/input01")))
    println(part2(readInput("day01/input01")))
}
