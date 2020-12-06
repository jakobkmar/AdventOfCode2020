package net.axay.adventofcode.day4

import net.axay.adventofcode.common.Day

fun main() = Day4.run()

object Day4 : Day(4) {
    private val passports = inputStringGrouped.map { Passport(it.replace(System.lineSeparator(), " ")) }

    override fun part1() = println(passports.count { it.validate(validator, true) })

    override fun part2() = println(passports.count { it.validate(validator) })
}

val validator = mapOf<String, (String) -> Boolean>(
    "byr" to { it in 1920..2002 },
    "iyr" to { it in 2010..2020 },
    "eyr" to { it in 2020..2030 },
    "hgt" to { when {
        it.endsWith("cm") -> it.removeSuffix("cm") in 150..193
        it.endsWith("in") -> it.removeSuffix("in") in 59..76
        else -> false
    } },
    "hcl" to {
        if (it.startsWith('#'))
            it.removePrefix("#").all { char -> char in 'a'..'f' || char in '0'..'9' }
        else false
    },
    "ecl" to { when(it) {
        "amb", "blu", "brn", "gry", "grn", "hzl", "oth" -> true
        else -> false
    } },
    "pid" to { it.length == 9 && it.toIntOrNull() != null }
)

class Passport(serializedLine: String) {
    private val fields = HashMap<String, String>()

    init {
        println(serializedLine)
        serializedLine.split(' ').map { it.split(':') }.forEach { fields[it[0]] = it[1] }
    }

    fun validate(keys: Map<String, (String) -> Boolean>, ignoreCondition: Boolean = false) =
        keys.all { fields[it.key]?.let { value -> if (ignoreCondition) true else it.value.invoke(value) } == true }
}

operator fun IntRange.contains(string: String) = string.toIntOrNull()?.let { it in this } ?: false