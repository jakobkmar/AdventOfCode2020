package net.axay.adventofcode.day5

import net.axay.adventofcode.common.Day

fun main() = Day5.run()

object Day5 : Day(5) {
    override fun part1() = println(inputLines.map { it.seatID }.maxOrNull())

    override fun part2() {
        inputLines.map { it.seatID }.sorted().fold<Int, Int?>(null) { prev, current ->
            if (prev != null && prev + 1 != current) {
                println(current - 1)
                return
            }
            current
        }
    }
}

val String.seatID get() = (0..127).toList().foldHalfWithRule(take(7), 'F', 'B').first() * 8 +
        (0..7).toList().foldHalfWithRule(takeLast(3), 'L', 'R').first()

fun List<Int>.foldHalfWithRule(rule: String, lowerOn: Char, upperOn: Char) = rule.fold(this) { list, char ->
    when (char) {
        lowerOn -> list.take(list.size / 2)
        upperOn -> list.takeLast(list.size / 2)
        else -> list
    }
}