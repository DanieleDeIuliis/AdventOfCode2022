package day6

object Day6 {
    fun part1(input: String): Int {
        repeat(input.length - 3) {
            val distinctChars = input.subSequence(it, it + 4).toSet()
            if(distinctChars.size == 4) {
                return it + 4
            }
        }
        return -1
    }

    fun part2(input: String): Int {
        return 123456789
    }
}