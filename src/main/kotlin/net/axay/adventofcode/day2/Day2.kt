package net.axay.adventofcode.day2

import net.axay.adventofcode.common.Day

fun main() = Day2.run()

object Day2 : Day(2) {
    override fun part1() {
        println("${validate { pair, char, password ->
            password.count { it == char } in pair.first .. pair.second
        }} passwords were valid")
    }

    override fun part2() {
        println("${validate { pair, char, password ->
            (password[pair.first - 1] == char) xor (password[pair.second - 1] == char)
        }} passwords were valid")
    }

    private fun validate(validator: (pair: Pair<Int, Int>, char: Char, password: String) -> Boolean) =
        inputLines.count { line -> line.split(' ').let { checkPassword(it[0], it[1], it[2], validator) } }
}

fun checkPassword(
    serializedPair: String, serializedChar: String, password: String,
    validator: (pair: Pair<Int, Int>, char: Char, password: String) -> Boolean
) = validator.invoke(
    serializedPair.split('-').let { it[0].toInt() to it[1].toInt() },
    serializedChar[0],
    password
)