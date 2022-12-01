import day1.maxCaloriesFirstElf
import day1.maxCaloriesFirstThreeElves
import java.io.File

private const val resources = "src/main/resources/"

fun main() {
    val input = readInput("input.txt")
    println(maxCaloriesFirstElf(input))
    println(maxCaloriesFirstThreeElves(input))
}

private fun readInput(filename: String): String {
    return File("$resources$filename").readText()
}