package net.axay.adventofcode.day8

import net.axay.adventofcode.common.Day

fun main() = Day8.run()

object Day8 : Day(8) {
    val statements = inputLines.mapIndexed { index, s -> Operation(s.split(' '), index) }

    fun cleanUsed() = statements.forEach { it.alreadyUsed = false }

    override fun part1() = statements.first().execute()

    override fun part2() = statements.first()
        .execute(statements.indices.first { !statements.first().checkInfinite(it) })
}

class Operation(serializedOperation: List<String>, private val index: Int) {
    var alreadyUsed = false

    private val _name = serializedOperation[0]
    private val argument = serializedOperation[1].toInt()

    private fun name(flipIndex: Int?) =
        if (flipIndex == index) when (_name) {
            "jmp" -> "nop"
            "nop" -> "jmp"
            else -> _name
        } else _name

    private fun isUsed() = if (alreadyUsed) true else {
        alreadyUsed = true
        false
    }

    fun execute(indexOfChanged: Int? = null, accumulator: Int = 0): Int =
        if (isUsed()) accumulator else {
            val newAccumulator = accumulator + if (name(indexOfChanged) == "acc") argument else 0
            Day8.statements.getOrNull(index + if (name(indexOfChanged) == "jmp") argument else 1)
                ?.execute(indexOfChanged, newAccumulator) ?: newAccumulator
        }.also { Day8.cleanUsed() }

    fun checkInfinite(indexOfChanged: Int?): Boolean =
        if (isUsed()) true else {
            Day8.statements.getOrNull(index + if (name(indexOfChanged) == "jmp") argument else 1)
                ?.checkInfinite(indexOfChanged) ?: false
        }.also { Day8.cleanUsed() }
}