package day1

import java.io.File

fun maxCalories(filename: String) : Int {
    val input = File("src/main/resources/$filename").readText()
    return input.split("\n\n").maxOf { it.toNumbers().sum() }
}

fun String.toNumbers() : List<Int> = this.split("\n").map(String::toInt)
