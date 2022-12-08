package day8

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day8Test {
    @Test
    fun `part 1`() {
        val input = """
            30373
            25512
            65332
            33549
            35390
        """.trimIndent()

        val result = Day8.part1(input)

        assertThat(result).isEqualTo(21)
    }
}