package net.axay.adventofcode.day3

import net.axay.adventofcode.common.Day

fun main() = Day3.run()

object Day3 : Day(3) {
    private val treeGrid = TreeGrid(inputLines)

    override fun part1() {
        println("There were ${treeGrid.countTrees(3 to 1)} trees on the slope")
    }

    override fun part2() {
        listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
            .map { treeGrid.countTrees(it).toLong() }
            .reduce { acc, i -> acc * i }
            .also { println("All results multiplied with each other: $it") }
    }
}

class TreeGrid(private val serializedMap: List<String>) {
    private val width = serializedMap.first().length

    fun countTrees(slope: Pair<Int, Int>) =
        (serializedMap.indices step slope.second)
            .map { (((it / slope.second) * slope.first) % width) to it }
            .filter { serializedMap[it.second][it.first] == '#' }
            .size
}