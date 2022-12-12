package day12

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day12Test {
    @Test
    fun `part 1`() {
        val input = """
            Sabqponm
            abcryxxl
            accszExk
            acctuvwj
            abdefghi
        """.trimIndent()

        val result = Day12.part1(input)

        assertThat(result).isEqualTo(31)
    }

    @Test
    fun `part 2`() {
        val input = """
            Sabqponm
            abcryxxl
            accszExk
            acctuvwj
            abdefghi
        """.trimIndent()

        val result = Day12.part2(input)

        assertThat(result).isEqualTo(29)
    }
}