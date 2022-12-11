package day11

import java.util.*
import kotlin.math.floor

object Day11 {
    fun part1(input: String): Int {
        val monkeys = input.split("\n\n").map {
            val lines = it.split("\n").drop(1)
            val items =
                lines.first().trim().removePrefix("Starting items:").trim().split("\\s?,\\s?".toRegex()).map(String::toInt)
            val (operator, value) = lines[1].trim().removePrefix("Operation: new = old").trim().split(" ")
            val operation = if(operator == "+") {
                { old: Int ->
                    old +  try { value.toInt() } catch (e: NumberFormatException) { old }
                }
            } else {
                { old: Int ->
                    old * try { value.toInt() } catch (e: NumberFormatException) { old }
                }
            }
            val divisibleBy = lines[2].trim().split(" ").last().toInt()
            val monkeyIdTrue = lines[3].trim().split(" ").last().toInt()
            val monkeyIdFalse = lines[4].trim().split(" ").last().toInt()
            Monkey(LinkedList(items), monkeyIdTrue, monkeyIdFalse, divisibleBy, operation)
        }

        repeat(20) {
            monkeys.forEach { monkey ->
                while(monkey.hasItems()) {
                    val thrownItem = monkey.throwItem()
                    monkeys[thrownItem.monkeyId].addItem(thrownItem.value)
                }
            }
        }
        val topmostMonkeys = monkeys.sortedByDescending(Monkey::inspectedItems).take(2)
        return topmostMonkeys[0].inspectedItems * topmostMonkeys[1].inspectedItems
    }

    fun part2(input: String): Int {
        return 14
    }
}


class Monkey(
    private val items: LinkedList<Int>,
    private val monkeyTrueId: Int,
    private val monkeyFalseId: Int,
    private val divisibleBy: Int,
    private val operation: (Int) -> Int,
    var inspectedItems: Int = 0
) {

    fun throwItem(): ThrowItem {
        val item = items.remove()
        inspectedItems++
        val newWorryLevelItem = operation(item).toDouble()
        val reducedWorryLevelItem = floor(newWorryLevelItem / 3).toInt()
        val throwToMonkeyId =
            if(reducedWorryLevelItem % divisibleBy == 0) {
                monkeyTrueId
            } else {
                monkeyFalseId
            }
        return ThrowItem(reducedWorryLevelItem, throwToMonkeyId)
    }

    fun hasItems() = !items.isEmpty()

    fun addItem(item: Int) = items.add(item)
    override fun toString(): String {
        return "Monkey(items=$items, monkeyTrueId=$monkeyTrueId, monkeyFalseId=$monkeyFalseId, divisibleBy=$divisibleBy, operation=$operation, inspectedItems=$inspectedItems)"
    }


}

data class ThrowItem(val value: Int, val monkeyId: Int)