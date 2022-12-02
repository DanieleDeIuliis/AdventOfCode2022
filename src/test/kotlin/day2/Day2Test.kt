package day2

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun `Should return total score for all rounds`() {
        val input = "A Y\nB X\nC Z"

        val result = Day2.part1(input)

        assertThat(result).isEqualTo(15)
    }

    @Test
    fun `Should return total score for all rounds when the second column means what you should do`() {
        val input = "A Y\nB X\nC Z\nB Y"

        val result = Day2.part2(input)

        assertThat(result).isEqualTo(17)
    }
}