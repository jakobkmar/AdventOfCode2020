package net.axay.adventofcode.day10

import kotlinx.coroutines.*
import net.axay.adventofcode.common.Day

fun main() = Day10.run()

object Day10 : Day(10) {
    private val adapters = inputLines.map { it.toInt() }.sorted().toMutableList().apply {
        this.add(0, 0)
        this += this.last() + 3
    }

    override fun part1() = mutableListOf<Int>().run {
        var previous = 0
        adapters.forEach {
            this += it - previous
            previous = it
        }
        this.count { it == 1 } * this.count { it == 3 }
    }

    override fun part2() = getWays()

    private val steps = HashMap<Int, Long>()
    private fun getWays(index: Int = 0): Long {
        if (index == adapters.lastIndex)
            return 1L
        return steps[index] ?: kotlin.run {
            var ways = 0L
            for (i in index + 1 .. (index + 3).let { if (it > adapters.lastIndex) adapters.lastIndex else it })
                if (adapters[i] - adapters[index] <= 3)
                    ways += getWays(i)
            steps[index] = ways
            return@run ways
        }
    }
}