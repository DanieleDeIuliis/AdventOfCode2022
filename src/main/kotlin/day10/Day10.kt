package day10

import kotlin.math.absoluteValue

object Day10 {
    fun part1(input: String): Int {
        var numberOfCycles = 0
        var valueOfRegister = 1
        var currentCycleToMultiply = 20
        var result = 0
        val operations = extractOperations(input)

        operations.forEach {
            numberOfCycles += 1
            if (numberOfCycles == currentCycleToMultiply) {
                result += currentCycleToMultiply * valueOfRegister
                currentCycleToMultiply += 40
            }
            valueOfRegister += it.toAdd
        }
        if((numberOfCycles - 20) % 40 == 0) {
            result += currentCycleToMultiply * valueOfRegister
        }
        return result
    }

    private fun extractOperations(input: String): List<Operation> {
        val operations = input.split("\n").flatMap {
            if (it.trim() == "noop") {
                listOf(Operation())
            } else {
                listOf(Operation(), Operation(it.trim().split(" ").last().toInt()))
            }
        }
        return operations
    }

    fun part2(input: String): String {
        val operations = extractOperations(input)
        var crtCenter = 1
        val grid = List(6) { MutableList(40) { '.' } }
        operations.forEachIndexed { index, operation ->
            val currentCol = index % 40
            val currentRow = index / 40
            if((crtCenter - currentCol).absoluteValue <= 1){
                grid[currentRow][currentCol] = '#'
            }
            crtCenter += operation.toAdd
        }

        return grid.print()
        }
    }

    private fun List<MutableList<Char>>.print(): String {
        return joinToString(separator = "\n") {
            it.joinToString(separator = "")
        }
    }

data class Operation(val toAdd: Int = 0) {}