package day25

import readInput
import kotlin.system.measureTimeMillis


data class Area(val input: List<String>) {
    private val width = input.first().length
    private val height = input.size

    data class Herd(val x: Int, val y: Int, val isHor: Boolean)

    private var herds = buildSet {
        input.forEachIndexed { y, line ->
            line.forEachIndexed { x, c -> if (c != '.') add(Herd(x, y, c == '>')) }
        }
    }

    private fun move(herd: Herd): Pair<Herd, Int> {
        var (xx, yy) = herd
        if (herd.isHor) {
            xx = (herd.x + 1) % width
        } else {
            yy = (herd.y + 1) % height
        }
        if (herds.firstOrNull { it.x == xx && it.y == yy } == null) {
            return Pair(Herd(xx, yy, herd.isHor), 1)
        }
        return Pair(Herd(herd.x, herd.y, herd.isHor), 0)
    }

    fun step(): Int {
        var changes = 0
        herds = buildSet {
            herds.forEach { herd ->
                if (herd.isHor) {
                    val (newHerd, c) = move(herd)
                    changes += c
                    add(newHerd)
                } else {
                    add(herd)
                }
            }
        }

        herds = buildSet {
            herds.forEach { herd ->
                if (herd.isHor) {
                    add(herd)
                } else {
                    val (newHerd, c) = move(herd)
                    changes += c
                    add(newHerd)
                }
            }
        }
        return changes
    }

    override fun toString() = buildString {
        for (y in 0 until height) {
            for (x in 0 until width) {
                val h = herds.firstOrNull { it.x == x && it.y == y }
                if (h == null) {
                    append('.')
                } else {
                    if (h.isHor) append('>') else append('V')
                }
            }
            appendLine()
        }
    }
}

fun part1(input: List<String>): Int {
    val area = Area(input)
    var cc = generateSequence(2) { it + 1 }.takeWhile { area.step() != 0 }.last()
    var count = 0
//    while (true) {
//        count += 1
//        if (area.step() == 0) break
//    }
    println(cc)
    return cc
}

fun main() {
    check(part1(readInput("day25/test3")) == 58)
    measureTimeMillis { print("⭐️ Part1: ${part1(readInput("day25/input"))}") }.also { time -> println(" in $time ms") }
}

