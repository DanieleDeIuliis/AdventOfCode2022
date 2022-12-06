package day6

object Day6 {
    fun part1(input: String): Int {
        return getEndOfMarker(input, 4)
    }

    private fun getEndOfMarker(input: String, markerSize: Int): Int {
        repeat(input.length - markerSize - 1) {
            val distinctChars = input.subSequence(it, it + markerSize).toSet()
            if (distinctChars.size == markerSize) {
                return it + markerSize
            }
        }
        return -1
    }

    fun part2(input: String): Int {
        return getEndOfMarker(input, 14)
    }
}