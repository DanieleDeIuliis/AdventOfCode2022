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
                    tail.getCloser(head, movement.direction)
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
        return 123
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

    private fun Position.getCloser(head: Position, direction: String) {
        if(row == head.row || col == head.col) {
            move(direction)
        } else {
            when(direction) {
                "R" -> {
                    col += 1
                    followRow(head)
                }
                "L" -> {
                    col -= 1
                    followRow(head)
                }
                "U" -> {
                    row += 1
                    followCol(head)
                }
                "D" -> {
                    row -= 1
                    followCol(head)
                }
            }
        }
    }

    private fun Position.followCol(head: Position) {
        if (col > head.col ) {
            col -= 1
        } else {
            col += 1
        }
    }

    private fun Position.followRow(head: Position) {
        if (row > head.row) {
            row -= 1
        } else {
            row += 1
        }
    }
}


