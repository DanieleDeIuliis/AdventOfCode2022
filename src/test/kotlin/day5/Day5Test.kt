package day5

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day5Test {
    @Test
    fun `part 1`() {
        val input =  "    [D]    \n" +
                            "[N] [C]    \n" +
                            "[Z] [M] [P]\n" +
                            " 1   2   3 \n" +
                            "\n" +
                            "move 1 from 2 to 1\n" +
                            "move 3 from 1 to 3\n" +
                            "move 2 from 2 to 1\n" +
                            "move 1 from 1 to 2"

        val result = Day5.part1(input)

        assertThat(result).isEqualTo("CMZ")
    }

    @Test
    fun `part 2`() {
        val input =  "    [D]    \n" +
                            "[N] [C]    \n" +
                            "[Z] [M] [P]\n" +
                            " 1   2   3 \n" +
                            "\n" +
                            "move 1 from 2 to 1\n" +
                            "move 3 from 1 to 3\n" +
                            "move 2 from 2 to 1\n" +
                            "move 1 from 1 to 2"

        val result = Day5.part2(input)

        assertThat(result).isEqualTo("MCD")
    }

}