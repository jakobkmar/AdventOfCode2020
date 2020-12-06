package net.axay.adventofcode.day6

import net.axay.adventofcode.common.Day

fun main() = Day6.run()

object Day6 : Day(6) {
    private val groups = inputLinesGrouped.map { it.map { line -> line.toSet() } }

    override fun part1() = println(groups.map { it.flatten().toSet().size }.sum())

    override fun part2() = println(groups.map { it.reduce { acc, set -> acc intersect set }.size }.sum())
}