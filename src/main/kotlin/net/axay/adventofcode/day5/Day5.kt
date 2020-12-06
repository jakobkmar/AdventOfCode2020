package net.axay.adventofcode.day5

import net.axay.adventofcode.common.Day

fun main() = Day5.run()

object Day5 : Day(5) {
    private val passIDs = inputLines.map { it.replace(mapOf('F' to '0', 'B' to '1', 'L' to '0', 'R' to '1')) }
        .map { it.take(7).toInt(2) * 8 + it.takeLast(3).toInt(2) } // specification -> binary -> int

    override fun part1() = passIDs.maxOrNull()

    override fun part2() = (passIDs.minOrNull()!!..passIDs.maxOrNull()!!).sum() - passIDs.sum()
}

fun String.replace(replacementMap: Map<Char, Char>) =
    StringBuilder().apply { this@replace.forEach { append(replacementMap[it] ?: it) } }.toString()