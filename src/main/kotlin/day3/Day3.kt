package day3

object Day3 {
    fun part1(input : String) : Int {
        val rucksacks = input.split("\n")
        return rucksacks.sumOf {
            val (firstCompartment, secondCompartment) = it.chunked(it.length/2)
            val intersect = firstCompartment.toSet().intersect(secondCompartment.toSet()).single()
            getPriority(intersect)
        }
    }

    fun part2(input : String) : Int = 1

    private fun getPriority(letter: Char) : Int{
        return when {
            letter.isUpperCase() -> letter - 'A' + 27
            letter.isLowerCase() -> letter - 'a' + 1
            else -> throw IllegalArgumentException()
        }
    }
}