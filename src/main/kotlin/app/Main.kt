import day1.maxCaloriesFirstElf
import day1.maxCaloriesFirstThreeElves
import java.io.File

private const val resources = "src/main/resources/"

fun main() {
    executeWithInput("inputDay1.txt", ::maxCaloriesFirstElf, ::maxCaloriesFirstThreeElves)
}

private fun executeWithInput(filename: String, part1Action: (String) -> Any, part2Action: (String) -> Any) {
    val input = readInput(filename)
    println(part1Action(input))
    println(part2Action(input))
}

private fun readInput(filename: String): String {
    return File("$resources$filename").readText()
}