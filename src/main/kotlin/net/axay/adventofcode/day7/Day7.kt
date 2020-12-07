package net.axay.adventofcode.day7

import net.axay.adventofcode.common.Day

fun main() = Day7.run()

object Day7 : Day(7) {
    val rules = inputLines.map { line ->
        Rule(line.split(" contain ").let { it[0] to it[1].split(',') }).let { it.bagName to it }
    }.toMap()

    override fun part1() = rules.values.count { it.containsShinyGold() }

    override fun part2() = rules["shiny gold"]?.countCarry()
}

class Rule(serializedRule: Pair<String, List<String>>) {
    val bagName: String = serializedRule.first.removeSuffix(" bags")
    val contains = if (!serializedRule.second.first().startsWith("no")) serializedRule.second.map { contains ->
            contains.removePrefix(" ").split(' ').let { it[0].toInt() to "${it[1]} ${it[2]}" }
    } else emptyList()

    fun containsShinyGold(): Boolean =
        contains.any { it.second == "shiny gold" || (Day7.rules[it.second]?.containsShinyGold() ?: false) }

    fun countCarry(): Int =
        contains.map { it.first }.sum() + contains.map { it.first * (Day7.rules[it.second]?.countCarry() ?: 0) }.sum()
}