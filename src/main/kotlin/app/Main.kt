
import day11.Day11
import java.io.File

private const val resources = "src/main/resources/"

fun main() {
    //executeWithInput("inputDay1.txt", ::maxCaloriesFirstElf, ::maxCaloriesFirstThreeElves)
    //executeWithInput("inputDay2.txt", Day2::part1, Day2::part2)
    //executeWithInput("inputDay3.txt", Day3::part1, Day3::part2)
    //executeWithInput("inputDay4.txt", Day4::part1, Day4::part2)
    //executeWithInput("inputDay5.txt", Day5::part1, Day5::part2)
    //executeWithInput("inputDay6.txt", Day6::part1, Day6::part2)
    //executeWithInput("inputDay7.txt", Day7::part1, Day7::part2)
    //executeWithInput("inputDay8.txt", Day8::part1, Day8::part2)
    //executeWithInput("inputDay9.txt", Day9::part1, Day9::part2)
    //executeWithInput("inputDay10.txt", Day10::part1, Day10::part2)
    executeWithInput("inputDay11.txt", Day11::part1, Day11::part2)

}

private fun executeWithInput(filename: String, part1Action: (String) -> Any, part2Action: (String) -> Any) {
    val input = readInput(filename)
    println(part1Action(input))
    println(part2Action(input))
}

private fun readInput(filename: String): String {
    return File("$resources$filename").readText()
}