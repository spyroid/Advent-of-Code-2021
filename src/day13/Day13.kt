package day13

import readInput
import kotlin.system.measureTimeMillis

fun main() {

    data class Point(var x: Int, var y: Int)

    class Paper(input: List<String>) {

        var points = mutableSetOf<Point>()
        val folds = mutableListOf<Point>()

        init {
            input.filter { it.isNotBlank() }.forEach { line ->
                if (line.contains("fold")) {
                    val s = line.split(" ").last().split("=")
                    if (s[0] == "x") folds.add(Point(s[1].toInt(), 0)) else folds.add(Point(0, s[1].toInt()))
                } else {
                    val (x, y) = line.split(",").map { it.toInt() }
                    points.add(Point(x, y))
                }
            }
        }

        fun fold() {
            val fold = folds.removeFirst()
            if (fold.x == 0) {
                points = points.onEach { if (it.y > fold.y) it.y = fold.y * 2 - it.y }.toMutableSet()
            } else {
                points = points.onEach { if (it.x > fold.x) it.x = fold.x * 2 - it.x }.toMutableSet()
            }
        }

        fun foldAll() {
            while (folds.isNotEmpty()) fold()
        }

        override fun toString() = buildString {
            val xx = points.maxOf { it.x }
            val yy = points.maxOf { it.y }
            for (y in 0..yy) {
                for (x in 0..xx) {
                    if (Point(x, y) in points) append("#") else append(" ")
                }
                appendLine()
            }
        }
    }

    fun part1(input: List<String>): Int {
        val paper = Paper(input)
        paper.fold()
        return paper.points.size
    }


    fun part2(input: List<String>): Int {
        val paper = Paper(input)
        paper.foldAll()
        println(paper)
        return 0
    }


    val testData = readInput("day13/test")
    val inputData = readInput("day13/input")

    var res1 = part1(testData)
    check(res1 == 17) { "Expected 17 but got $res1" }

    var time = measureTimeMillis { res1 = part1(inputData) }
    println("Part1: $res1 in $time ms")

    time = measureTimeMillis { res1 = part2(inputData) }
    println("Part2: $res1 in $time ms")
}

