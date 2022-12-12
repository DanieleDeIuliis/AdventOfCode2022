package day12

import java.util.*
import kotlin.math.absoluteValue

object Day12 {
    fun part1(input: String): Int {
        val heightMap = computeHeightMap(input)
        return simpleBfs(heightMap)
    }

    fun part2(input: String): Int {
        return bfsFromAllStarts(computeHeightMap(input))
    }

    private fun simpleBfs(heightMap: HeightMap): Int {
        return bfs(heightMap.matrix, heightMap.startPositions.first(), heightMap.end)
    }

    private fun bfsFromAllStarts(heightMap: HeightMap): Int {
        return heightMap.startPositions.map { bfs(heightMap.matrix, it, heightMap.end) }.filter { it > 0 }.min()
    }

    private fun bfs(matrix: Array<IntArray>, start: Position, end: Position): Int {
        val toVisit = LinkedList<Position?>()
        toVisit.add(start)
        toVisit.add(null)
        val visited = mutableSetOf(start)
        var level = 1
        while (toVisit.isNotEmpty()) {
            if (toVisit.peek() == null) {
                toVisit.remove()
                continue
            }
            while (toVisit.peek() != null) {
                val current = toVisit.remove()!!
                val children = current.next(matrix)
                if (children.any { it == end }) {
                    return level
                }

                toVisit.addAll(children.filterNot { visited.contains(it) })
                visited.addAll(children)
            }
            toVisit.add(null)
            level++
        }
        return -1
    }

    private fun computeHeightMap(input: String): HeightMap {
        lateinit var  originalStart: Position
        lateinit var end: Position
        val matrix = input.split("\n").mapIndexed { row, line ->
            line.mapIndexed { col, letter ->
                when (letter) {
                    'S' -> {
                        originalStart = Position(row,col)
                        0
                    }
                    'E' -> {
                        end = Position(row, col)
                        'z' - 'a'
                    }
                    else -> letter - 'a'
                }
            }.toIntArray()
        }.toTypedArray()
        val startPositions = matrix.flatMapIndexed { rowIndex, row ->
            row.mapIndexed { colIndex, value ->
                if(value == 0) {
                    Position(rowIndex, colIndex)
                } else {
                    null
                }
            }.filterNotNull()
        }.toMutableList()

        startPositions.remove(originalStart)
        startPositions.add(0, originalStart)
        return HeightMap(matrix, startPositions, end)
    }
}

private fun Position.next(matrix: Array<IntArray>): List<Position> {
    val left = if(matrix.canMove(this, row, column + 1)) {
        Position(row, column + 1)
    } else {
        null
    }

    val right = if(matrix.canMove(this, row, column - 1)) {
        Position(row, column - 1)
    } else {
        null
    }

    val up = if(matrix.canMove(this, row + 1, column)) {
        Position(row + 1, column)
    } else {
        null
    }

    val down = if(matrix.canMove(this, row - 1, column)) {
        Position(row - 1, column)
    } else {
        null
    }
    return listOfNotNull(left, right, up, down)
}

private fun Array<IntArray>.canMove(position: Position, toRow: Int, toColumn: Int): Boolean {
    val positionValue = this[position.row][position.column]
    val toValue = this.getOrNull(toRow)?.getOrNull(toColumn) ?: return false

    return positionValue > toValue || (toValue - positionValue).absoluteValue <= 1
}

data class HeightMap(val matrix: Array<IntArray>, val startPositions: List<Position>, val end: Position)

data class Position(val row: Int, val column: Int)