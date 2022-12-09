package day9

import kotlin.math.pow
import kotlin.math.sqrt

object Day9 {
    fun part1(input: String): Int {
        val movements = input.split("\n").map { movement ->
            val (direction, times) = movement.trim().split(" ")
            Movement(direction, times.toInt())
        }

        val visited = mutableSetOf(Position(0, 0))

        val head = Position(0, 0)
        val tail = Position(0, 0)

        movements.forEach { movement ->
            repeat(movement.times) {
                head.move(movement.direction)
                if(tooDistant(head, tail)) {
                    tail.getCloser(head)
                    visited.add(tail.copy())
                }
            }
        }
        return visited.size
    }

    private fun tooDistant(head: Position, tail: Position): Boolean {
        val distance = sqrt((tail.row - head.row).toDouble().pow(2.0) + (tail.col - head.col).toDouble().pow(2.0))
        return distance > 1.5
    }

    fun part2(input: String): Int {
        val movements = input.split("\n").map { movement ->
            val (direction, times) = movement.trim().split(" ")
            Movement(direction, times.toInt())
        }

        val visited = mutableSetOf(Position(0, 0))

        val nodes = List(10) { Position(0,0) }

        movements.forEach { movement ->
            repeat(movement.times) {
                nodes[0].move(movement.direction)
                for(index in 0 until nodes.size - 1){
                    val head = nodes[index]
                    val tail = nodes[index + 1]
                    if (tooDistant(head, tail)) {
                        tail.getCloser(head)
                        if(index + 1 == nodes.size - 1) {
                            visited.add(tail.copy())
                        }
                    }
                }
            }
        }
        return visited.size
    }

    data class Movement(val direction: String, val times: Int)

    data class Position(var row: Int, var col: Int)

    private fun Position.move(direction: String) {
        when(direction) {
            "R" -> col += 1
            "L" -> col -= 1
            "U" -> row += 1
            "D" -> row -= 1
        }
    }

    private fun Position.getCloser(to: Position) {
        when {
            row == to.row -> getCloserHorizontally(to)
            col == to.col -> getCloserVertically(to)
            else -> getCloserDiagonally(to)
        }
    }

    private fun Position.getCloserDiagonally(to: Position) {
        when {
            needsToNorthEast(to) -> {
                col += 1
                row += 1
            }

            needsToGoNorthWest(to) -> {
                col -= 1
                row += 1
            }

            needsToGoSouthWest(to) -> {
                row -= 1
                col -= 1
            }

            needsToGoSouthEast(to) -> {
                row -= 1
                col += 1
            }
        }
    }

    private fun Position.needsToGoSouthEast(head: Position) = row > head.row && col < head.col

    private fun Position.needsToGoSouthWest(head: Position) = row > head.row && col > head.col

    private fun Position.needsToGoNorthWest(head: Position) = row < head.row && col > head.col

    private fun Position.needsToNorthEast(head: Position) = row < head.row && col < head.col

    private fun Position.getCloserHorizontally(head: Position) {
        if (col > head.col ) {
            col -= 1
        } else {
            col += 1
        }
    }

    private fun Position.getCloserVertically(head: Position) {
        if (row > head.row) {
            row -= 1
        } else {
            row += 1
        }
    }
}


