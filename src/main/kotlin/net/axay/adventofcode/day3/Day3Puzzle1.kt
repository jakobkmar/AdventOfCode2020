package net.axay.adventofcode.day3

import java.io.File

fun main() {

    val treeGrid = TreeGrid(File("./src/main/resources/input/Day3.txt").readLines())

    var hitGround = false
    var currentPosition = Position(1, 1)
    var treeCounter = 0
    while (!hitGround) {
        currentPosition = currentPosition.move(1, 3)
        if (treeGrid.isTree(currentPosition))
            treeCounter++
        if (treeGrid.isGround(currentPosition))
            hitGround = true
    }

    println("There were $treeCounter trees on the slope")

}