package day4

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day4Test {
    @Test
    fun `Should count the total assignments that overlaps`() {
        val input = """
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8
        """.trimIndent()

        val result = Day4.part1(input)

        assertThat(result).isEqualTo(2)
    }
}