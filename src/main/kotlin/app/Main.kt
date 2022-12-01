import day1.maxCaloriesFirstElf
import day1.maxCaloriesFirstThreeElves
import java.io.File

private const val resources = "src/main/resources/"

fun main() {
    day1("inputDay1.txt")
}

private fun day1(filename: String) {
    executeWithInput(filename) {
        println(maxCaloriesFirstElf(it))
        println(maxCaloriesFirstThreeElves(it))
    }
}

private fun executeWithInput(filename: String, action: (String) -> Unit) {
    val input = readInput(filename)
    action(input)
}

private fun readInput(filename: String): String {
    return File("$resources$filename").readText()
}