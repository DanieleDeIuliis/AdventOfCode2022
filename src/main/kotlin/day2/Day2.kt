package day2

import java.lang.IllegalArgumentException
import kotlin.math.min

object Day2 {
    fun part1(input: String): Int {
        return input.split("\n").map { line ->
            val hands = line.split(" ")
            val opponent = Hand.fromLetter(hands.first())
            val mine = Hand.fromLetter(hands.last())

            mine.beats(opponent) + mine.value
        }.sum()
    }

    fun part2(input: String): Int {
        return 0
    }
}

enum class Hand(val value: Int) {
    ROCK(1),
    PAPER(2),
    SCISSOR(3);

    fun beats(opponent: Hand): Int {
        if(this == opponent) return 3
        return when(this) {
            ROCK -> if(opponent == SCISSOR) 6 else 0
            PAPER -> if(opponent == ROCK) 6 else 0
            SCISSOR -> if(opponent == PAPER) 6 else 0
        }
    }

    companion object {
        fun fromLetter(letter: String): Hand {
            return when(letter) {
                "A", "X" -> ROCK
                "B", "Y" -> PAPER
                "C", "Z" -> SCISSOR
                else -> throw IllegalArgumentException()
            }
        }
    }
}