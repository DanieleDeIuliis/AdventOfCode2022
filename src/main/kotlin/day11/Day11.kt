package day11

import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*

object Day11 {
    fun part1(input: String): Long {
        return inspectedItems(input, 20, 3)
    }

    fun part2(input: String): Long {
        return inspectedItems(input, 10_000, 1)
    }

    private fun inspectedItems(input: String, rounds: Int, reliefFactor: Int): Long {
        val monkeys = input.split("\n\n").map {
            val lines = it.split("\n").drop(1)
            val items =
                lines.first().trim().removePrefix("Starting items:").trim().split("\\s?,\\s?".toRegex())
                    .map(String::toBigDecimal)
            val (operator, value) = lines[1].trim().removePrefix("Operation: new = old").trim().split(" ")
            val operation = if (operator == "+") {
                { old: BigDecimal ->
                    old + try {
                        value.toBigDecimal()
                    } catch (e: NumberFormatException) {
                        old
                    }
                }
            } else {
                { old: BigDecimal ->
                    old * try {
                        value.toBigDecimal()
                    } catch (e: NumberFormatException) {
                        old
                    }
                }
            }
            val divisibleBy = lines[2].trim().split(" ").last().toInt()
            val monkeyIdTrue = lines[3].trim().split(" ").last().toInt()
            val monkeyIdFalse = lines[4].trim().split(" ").last().toInt()
            Monkey(LinkedList(items), monkeyIdTrue, monkeyIdFalse, divisibleBy, operation)
        }

        val gcd = monkeys.map { it.divisibleBy }.reduce { acc, value ->
            value * acc
        }
        repeat(rounds) {
            monkeys.forEach { monkey ->
                while (monkey.hasItems()) {
                    val thrownItem = monkey.throwItem(reliefFactor, gcd)
                    monkeys[thrownItem.monkeyId].addItem(thrownItem.value)
                }
            }
        }
        val topmostMonkeys = monkeys.sortedByDescending(Monkey::inspectedItems).take(2)
        return topmostMonkeys[0].inspectedItems * topmostMonkeys[1].inspectedItems
    }
}


class Monkey(
    private val items: LinkedList<BigDecimal>,
    private val monkeyTrueId: Int,
    private val monkeyFalseId: Int,
    val divisibleBy: Int,
    private val operation: (BigDecimal) -> BigDecimal,
    var inspectedItems: Long = 0
) {

    fun throwItem(reliefFactor: Int, mod: Int): ThrowItem {
        val item = items.remove()
        inspectedItems++
        val newWorryLevelItem = operation(item)
        val reducedWorryLevelItem = newWorryLevelItem.divide(reliefFactor.toBigDecimal(), RoundingMode.DOWN)
        val throwToMonkeyId =
            if(reducedWorryLevelItem.remainder(divisibleBy.toBigDecimal()) == BigDecimal.ZERO) {
                monkeyTrueId
            } else {
                monkeyFalseId
            }
        return ThrowItem(reducedWorryLevelItem.remainder(BigDecimal(mod)), throwToMonkeyId)
    }

    fun hasItems() = !items.isEmpty()

    fun addItem(item: BigDecimal) = items.add(item)
    override fun toString(): String {
        return "Monkey(items=$items, monkeyTrueId=$monkeyTrueId, monkeyFalseId=$monkeyFalseId, divisibleBy=$divisibleBy, operation=$operation, inspectedItems=$inspectedItems)"
    }


}

data class ThrowItem(val value: BigDecimal, val monkeyId: Int)