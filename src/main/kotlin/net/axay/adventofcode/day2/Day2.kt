package net.axay.adventofcode.day2

import net.axay.adventofcode.common.Day

fun main() = Day2.run()

object Day2 : Day(2) {
    override fun part1() =
        validate { pair, char, password -> password.count { it == char } in pair.first .. pair.second }

    override fun part2() =
        validate { pair, char, password -> (password[pair.first - 1] == char) xor (password[pair.second - 1] == char) }

    private fun validate(validator: (pair: Pair<Int, Int>, char: Char, password: String) -> Boolean) =
        "${
            inputLines.count { line -> line.split(' ').let { checkPassword(it[0], it[1], it[2], validator) } }
        } passwords were valid"
}

fun checkPassword(
    serializedPair: String, serializedChar: String, password: String,
    validator: (pair: Pair<Int, Int>, char: Char, password: String) -> Boolean
) = validator.invoke(
    serializedPair.split('-').let { it[0].toInt() to it[1].toInt() }, serializedChar[0], password
)