package net.axay.adventofcode.day1

import net.axay.adventofcode.common.Day

fun main() = Day1.run()

object Day1 : Day(1) {
    private val numbers = inputLines.map { it.toInt() }

    override fun part1() = println(check(2, 2020)?.reduce { acc, i -> acc * i })

    override fun part2() = println(check(3, 2020)?.reduce { acc, i -> acc * i })

    private fun check(numberAmount: Int, sum: Int): List<Int>? {
        if (numberAmount == 1) { if (numbers.contains(sum)) return listOf(sum) }
        else for (number in numbers)
            if (number <= sum) check(numberAmount - 1, sum - number)?.let {
                return listOf(listOf(number), it).flatten()
            }
        return null
    }
}