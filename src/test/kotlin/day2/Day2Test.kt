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
}