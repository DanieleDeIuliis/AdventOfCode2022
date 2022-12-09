package day9

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day9Test {

    @Test
    fun `part 1`() {
        val input = """
            R 4
            U 4
            L 3
            D 1
            R 4
            D 1
            L 5
            R 2
        """.trimIndent()

        val result = Day9.part1(input)

        assertThat(result).isEqualTo(13)
    }

    @Test
    fun `part 2`() {
        val input = """
            R 5
            U 8
            L 8
            D 3
            R 17
            D 10
            L 25
            U 20
        """.trimIndent()

        val result = Day9.part2(input)

        assertThat(result).isEqualTo(36)
    }

    @Test
    fun `part 2 piu piccolo`() {
        val input = """
            R 4
            U 4
            L 3
            D 1
            R 4
            D 1
            L 5
            R 2
        """.trimIndent()

        val result = Day9.part2(input)

        assertThat(result).isEqualTo(1)
    }
}
