package day3

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day3Test {
    @Test
    fun `Should return 157`() {
        val input = """
            vJrwpWtwJgWrhcsFMMfFFhFp
            jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
            PmmdzqPrVvPwwTWBwg
            wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
            ttgJtRGJQctTZtZT
            CrZsJsPPZsGzwwsLwLmpwMDw
        """.trimIndent()
        val result = Day3.part1(input)

        assertThat(result).isEqualTo(157)
    }
}