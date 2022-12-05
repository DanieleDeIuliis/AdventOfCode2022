package day5

import java.util.*

object Day5 {
    fun part1(input: String): String {
        val (textualLevels, textualMoves) = input.split("\n\n")
        val stacks = createStacks(textualLevels)
        val movements = parseMovements(textualMoves)
        movements.forEach { movement ->
            repeat(movement.amount) {
                val toMove = stacks[movement.from].pop()
                stacks[movement.to].push(toMove)
            }
        }
        return stacks.joinToString(separator = "") { it.popOrEmptyString() }
    }

    fun part2(input: String): String {
        val (textualLevels, textualMoves) = input.split("\n\n")
        val stacks = createStacks(textualLevels)
        val movements = parseMovements(textualMoves)
        movements.forEach { movement ->
            val cratesToMove = List(movement.amount) { stacks[movement.from].pop() }
            cratesToMove.asReversed().forEach {
                stacks[movement.to].push(it)
            }
        }
        return stacks.joinToString(separator = "") { it.popOrEmptyString() }
    }

    private fun Stack<String>.popOrEmptyString() = try {
        pop()
    } catch (e: EmptyStackException) {
        ""
    }

    private fun parseMovements(textualMoves: String): List<Movement> {
        return textualMoves.split("\n").map {
            val values = it.split(" ")
            Movement(values[1].toInt(), values[3].toInt() - 1, values[5].toInt() - 1)
        }
    }

    private fun createStacks(textualLevels: String): List<Stack<String>> {
        val levels = textualLevels.split("\n")
        val numberOfStacks = levels.last().trim().split("   ").size
        val stacks = List(numberOfStacks) { Stack<String>() }

        levels.dropLast(1).asReversed().forEach {
            val level = it.replace("\\s{4}".toRegex(), " [#] ")
                .replace("[\\[\\]]".toRegex(), "")
                .trim()
            level.split("\\s+".toRegex()).forEachIndexed { index, value ->
                if (value != "#") {
                    stacks[index].push(value)
                }
            }
        }
        return stacks
    }
}

data class Movement(val amount: Int, val from: Int, val to: Int)