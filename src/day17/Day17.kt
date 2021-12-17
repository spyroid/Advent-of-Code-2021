package day17

import com.github.ajalt.mordant.terminal.Terminal
import readInput
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.system.measureTimeMillis

data class Bullet(var dx: Int, var dy: Int, var x: Int = 0, var y: Int = 0) {
    var maxY = y
    fun step() {
        x += dx
        y += dy--
        if (dx > 0) dx -= 1 else dx = 0
        maxY = maxOf(maxY, y)
    }
}


class Simulation(val x1: Int, val x2: Int, val y1: Int, val y2: Int) {

    fun simulate(x: Int, y: Int): Bullet? {
        val b = Bullet(x, y)
        while (b.y >= y1 && b.x <= x2) {
//            println("* $b")
            b.step()
//            maxY = maxOf(maxY, b.y)
            if (b.x in x1..x2 && b.y in y1..y2) {
                println(">>>>>>>>> $b with $x $y")
                return b
            }
        }
        return null
    }

    fun findMaxY(): Pair<Int, Int> {
        var maxY = -1
        var count = 0

        for (x in 1..x2) {
            for (y in y1..y1.absoluteValue) {
                val b = Bullet(x, y)
//                println("simulate($x, $y)")
                val res = simulate(x, y)
                if (res != null) {
                    maxY = maxOf(maxY, res.maxY)
                    count++
                }
            }
        }
        return Pair(maxY, count)
    }
}


fun main() {


    fun part1(input: List<String>): Int {

        println(Simulation(20, 30, -10, -5).findMaxY())
        println(Simulation(48, 70, -189, -148).findMaxY())

        return 0
    }

    fun part2(input: List<String>): Int {
        return 0
    }


    val testData = readInput("day17/test")
    val inputData = readInput("day17/input")

    val term = Terminal()

    var res1 = part1(testData)
    check(res1 == 45) { "Expected 45 but got $res1" }

    var time = measureTimeMillis { res1 = part1(inputData) }
    term.success("⭐️ Part1: $res1 in $time ms")

    var res2 = 0
    time = measureTimeMillis { res2 = part2(inputData) }
    term.success("⭐️ Part2: $res2 in $time ms")
}

