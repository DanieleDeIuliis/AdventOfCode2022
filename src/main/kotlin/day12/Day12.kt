package day12

import java.util.*
import kotlin.math.absoluteValue

object Day12 {
    fun part1(input: String): Int {
        val heightMap = computeHeighMap(input).first()
        return bfs(heightMap)
    }

    fun part2(input: String): Int {
        return computeHeighMap(input).map { bfs(it) }.filter { it > 0 }.min()
    }

    private fun bfs(heightMap: HeightMap): Int {
        val toVisit = LinkedList<Position?>()
        toVisit.add(heightMap.start)
        toVisit.add(null)
        val visited = mutableSetOf(heightMap.start)
        var level = 1
        while (toVisit.isNotEmpty()) {
            if (toVisit.peek() == null) {
                toVisit.remove()
                continue
            }
            while (toVisit.peek() != null) {
                val current = toVisit.remove()!!
                val children = current.next(heightMap.matrix)
                if (children.any { it == heightMap.end }) {
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

    private fun computeHeighMap(input: String): List<HeightMap> {
        lateinit var end: Position
        val matrix = input.split("\n").mapIndexed { row, line ->
            line.mapIndexed { col, letter ->
                when (letter) {
                    'S' -> {
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
        val maps = mutableListOf<HeightMap>()
        matrix.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                if(value == 0) {
                    maps.add(HeightMap(matrix, Position(rowIndex, colIndex), end))
                }
            }
        }
        return maps
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

data class HeightMap(val matrix: Array<IntArray>, val start: Position, val end: Position) {

    override fun toString(): String {
        return "HeightMap(matrix=${matrix.forEach { println(it.joinToString(separator = " ")) }}, start=$start, end=$end)"
    }


}

data class Position(val row: Int, val column: Int)