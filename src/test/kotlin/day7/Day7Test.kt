package day7

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day7Test {
    @Test
    fun `part 1`() {
        val input = """
            $ cd /
            $ ls
            dir a
            14848514 b.txt
            8504156 c.dat
            dir d
            $ cd a
            $ ls
            dir e
            29116 f
            2557 g
            62596 h.lst
            $ cd e
            $ ls
            584 i
            $ cd ..
            $ cd ..
            $ cd d
            $ ls
            4060174 j
            8033020 d.log
            5626152 d.ext
            7214296 k
        """.trimIndent()

        val result = Day7.part1(input)

        assertThat(result).isEqualTo(95437)
    }
}