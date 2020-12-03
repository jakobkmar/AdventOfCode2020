package net.axay.adventofcode.day3

import java.io.File

fun main() {

    val treeGrid = TreeGrid(File("./src/main/resources/input/Day3.txt").readLines())

    val countedTrees = mutableListOf<Long>()
    listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2)).forEach { slope ->
        var hitGround = false
        var currentPosition = Position(1, 1)
        var treeCounter = 0
        while (!hitGround) {
            currentPosition = currentPosition.move(slope.second, slope.first)
            if (treeGrid.isTree(currentPosition))
                treeCounter++
            if (treeGrid.isGround(currentPosition))
                hitGround = true
        }
        countedTrees += treeCounter.toLong()
    }

    println("All results multiplied with each other: ${countedTrees.reduce { acc, i -> acc * i }}")

}