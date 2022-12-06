package day6

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day6Test {
    @Test
    fun `part 1`() {
        assertThat(Day6.part1("npmn")).isEqualTo(-1)
        assertThat(Day6.part1("nnmpa")).isEqualTo(5)
        assertThat(Day6.part1("nppdvjthqldpwncqszvftbrmjlhg")).isEqualTo(6)
        assertThat(Day6.part1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")).isEqualTo(10)
        assertThat(Day6.part1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")).isEqualTo(11)
    }

    @Test
    fun `part 2`() {
        assertThat(Day6.part2("mjqjpqmgbljsphdztnvjfqwrcgsmlb")).isEqualTo(19)
        assertThat(Day6.part2("bvwbjplbgvbhsrlpgdmjqwftvncz")).isEqualTo(23)
        assertThat(Day6.part2("nppdvjthqldpwncqszvftbrmjlhg")).isEqualTo(23)
        assertThat(Day6.part2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")).isEqualTo(29)
        assertThat(Day6.part2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")).isEqualTo(26)
    }
}