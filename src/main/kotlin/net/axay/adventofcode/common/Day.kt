@file:Suppress("MemberVisibilityCanBePrivate")

package net.axay.adventofcode.common

import java.io.File

abstract class Day(val dayOfMonth: Int) {

    val inputFile get() =
        File(this::class.java.classLoader.getResource("input/Day$dayOfMonth.txt")?.file
            ?: throw IllegalStateException("An input file for this day could not be found"))

    val inputLines get() = inputFile.readLines()

    fun run() {
        println("------------------------------")
        println("| Running puzzle of day $dayOfMonth |")
        println(" -> Running part 1:")
        part1()
        println(" -> Running part 2:")
        part2()
        println("| Finished puzzle of day $dayOfMonth |")
        println("------------------------------")
    }

    protected abstract fun part1()
    protected abstract fun part2()

}