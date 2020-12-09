package net.axay.adventofcode.day9

import net.axay.adventofcode.common.Day

fun main() = Day9.run()

const val PREAMBLE_SIZE = 25

object Day9 : Day(9) {
    private val numbers = inputLines.map { it.toLong() }

    private val firstInvalid = numbers.filterIndexed { index, i ->
        if (index >= PREAMBLE_SIZE)
            numbers.subList(index - PREAMBLE_SIZE, index).let {
                !it.any { int -> it.any { int2 -> int + int2 == i } }
            }
        else false
    }.first()

    override fun part1() = firstInvalid

    override fun part2() =
        numbers.indices.mapNotNull { addsUpTo(it) }.first().let { it.first() + it.last() }

    private fun addsUpTo(index: Int): List<Long>? {
        val range = mutableListOf<Long>()
        (index .. numbers.lastIndex).forEach {
            range += numbers[it]
            val thisSum = range.sum()
            if (thisSum == firstInvalid)
                return range.sorted()
            else if (thisSum > firstInvalid)
                return null
        }
        return null
    }
}