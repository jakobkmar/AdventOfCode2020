package net.axay.adventofcode.day3

data class Position(val down: Int, val right: Int) {
    fun move(down: Int, right: Int) = Position(this.down + down, this.right + right)
}

class TreeGrid(serializedMap: List<String>) {
    private val positions = HashMap<Position, Boolean>()
    private val width: Int
    private val height: Int

    init {
        serializedMap.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { charIndex, char ->
                positions[Position(lineIndex + 1, charIndex + 1)] = char == '#'
            }
        }
        width = serializedMap.first().length
        height = serializedMap.size
    }

    fun isTree(position: Position): Boolean {
        val checkDown = if (position.down <= height) position.down else throw InvalidPositionException()
        val checkRight = if (position.right > 0) {
            val modulo = (position.right % width)
            if (modulo == 0) width else modulo
        } else throw InvalidPositionException()

        return positions[Position(checkDown, checkRight)] ?: throw InvalidPositionException()
    }
    fun isGround(position: Position) = position.down == height
}

class InvalidPositionException : IllegalArgumentException("The given position does not exist")