package net.axay.adventofcode

import java.io.File

fun main() {

    val numbers = File("./src/main/resources/input/Day1Puzzle2.txt").readLines().map { it.toInt() }

    for (it in numbers) for (other in numbers) for (third in numbers) if (it + other + third == 2020) {
        println("$it + $other + $third == 2020\nERGEBNIS: $it * $other * $third == ${it * other * third}")
        return
    }

}