package net.axay.adventofcode

import java.io.File

fun main() {

    var validCounter = 0

    for (passwordLine in File("./src/main/resources/input/Day2Puzzle2.txt").readLines()) {
        val lineParts = passwordLine.split(' ')
        if (PasswordPolicy2(lineParts[0], lineParts[1]).isValid(lineParts[2]))
            validCounter++
    }

    println("$validCounter passwords were valid")

}

class PasswordPolicy2(serializedPair: String, serializedChar: String) {
    private val pair: Pair<Int, Int>
    private val char: Char

    init {
        val pairParts = serializedPair.split('-')
        pair = pairParts[0].toInt() to pairParts[1].toInt()
        char = serializedChar[0]
    }

    fun isValid(password: String) = (password[pair.first - 1] == char) xor (password[pair.second - 1] == char)
}