package net.axay.adventofcode

import java.io.File

fun main() {

    val numbers = File("./src/main/resources/input/Day1Puzzle1.txt").readLines().map { it.toInt() }

    for (it in numbers) for (other in numbers) if (it + other == 2020) {
        println("$it + $other == 2020\nERGEBNIS: $it * $other == ${it * other}")
        return
    }

    numbers.map {
    }

}