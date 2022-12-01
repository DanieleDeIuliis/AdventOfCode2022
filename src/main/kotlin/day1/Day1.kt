package day1

fun maxCaloriesFirstElf(input: String) : Int {
    return input.split("\n\n").maxOf { it.toNumbers().sum() }
}

fun maxCaloriesFirstThreeElves(input: String) : Int {
    val sums = input.split("\n\n").map { it.toNumbers().sum() }
    return sums.sorted().takeLast(3).sum()
}


fun String.toNumbers() : List<Int> = this.split("\n").map(String::toInt)
