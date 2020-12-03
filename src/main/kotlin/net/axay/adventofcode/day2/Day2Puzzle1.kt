package net.axay.adventofcode.day2

import java.io.File

fun main() {

    var validCounter = 0
    for (passwordLine in File("./src/main/resources/input/Day2.txt").readLines()) {
        val lineParts = passwordLine.split(' ')
        if (PasswordPolicy1(lineParts[0], lineParts[1]).isValid(lineParts[2]))
            validCounter++
    }

    println("$validCounter passwords were valid")

}

class PasswordPolicy1(serializedRange: String, serializedChar: String) {
    private val range: IntRange
    private val char: Char

    init {
        val rangeparts = serializedRange.split('-')
        range = rangeparts[0].toInt() .. rangeparts[1].toInt()
        char = serializedChar[0]
    }

    fun isValid(password: String) = password.toCharArray().filter { it == char }.size in range
}