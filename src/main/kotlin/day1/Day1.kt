package day1

import java.io.File

fun maxCaloriesFirstElf(filename: String) : Int {
    val input = File("src/main/resources/$filename").readText()
    return input.split("\n\n").maxOf { it.toNumbers().sum() }
}

fun String.toNumbers() : List<Int> = this.split("\n").map(String::toInt)


fun maxCaloriesFirstThreeElves(filename: String) : Int {
    val input = File("src/main/resources/$filename").readText()
    val sums = input.split("\n\n").map { it.toNumbers().sum() }
    return sums.sorted().takeLast(3).sum()
}