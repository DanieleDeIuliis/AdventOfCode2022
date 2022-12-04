
import day4.Day4
import java.io.File

private const val resources = "src/main/resources/"

fun main() {
    //executeWithInput("inputDay1.txt", ::maxCaloriesFirstElf, ::maxCaloriesFirstThreeElves)
    //executeWithInput("inputDay2.txt", Day2::part1, Day2::part2)
    //executeWithInput("inputDay3.txt", Day3::part1, Day3::part2)
    executeWithInput("inputDay4.txt", Day4::part1, Day4::part2)
}

private fun executeWithInput(filename: String, part1Action: (String) -> Any, part2Action: (String) -> Any) {
    val input = readInput(filename)
    println(part1Action(input))
    println(part2Action(input))
}

private fun readInput(filename: String): String {
    return File("$resources$filename").readText()
}