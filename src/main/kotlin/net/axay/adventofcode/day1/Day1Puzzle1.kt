package net.axay.adventofcode.day1

import java.io.File

fun main() {

    val numbers = File("./src/main/resources/input/Day1.txt").readLines().map { it.toInt() }

    for (it in numbers) for (other in numbers) if (it + other == 2020) {
        println("$it + $other == 2020\nERGEBNIS: $it * $other == ${it * other}")
        return
    }

}