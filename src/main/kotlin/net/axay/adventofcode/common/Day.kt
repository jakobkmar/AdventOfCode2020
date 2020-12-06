@file:Suppress("MemberVisibilityCanBePrivate")

package net.axay.adventofcode.common

import java.io.File

abstract class Day(val dayOfMonth: Int) {

    val inputFile get() =
        File(this::class.java.classLoader.getResource("input/Day$dayOfMonth.txt")?.file
            ?: throw IllegalStateException("An input file for this day could not be found"))

    val inputString get() = inputFile.readText()
    val inputLines get() = inputFile.readLines()

    val inputStringGrouped get() = inputString.split("${System.lineSeparator()}${System.lineSeparator()}")
    val inputLinesGrouped get() = inputStringGrouped.map { it.split(System.lineSeparator()) }

    fun run() {
        println("------------------------------")
        println("| Running puzzle of day $dayOfMonth |")
        println(" -> Running part 1:")
        println(part1())
        println(" -> Running part 2:")
        println(part2())
        println("| Finished puzzle of day $dayOfMonth |")
        println("------------------------------")
    }

    protected abstract fun part1(): Any?
    protected abstract fun part2(): Any?

}