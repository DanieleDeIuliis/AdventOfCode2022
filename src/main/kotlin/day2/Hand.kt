package day2

import java.lang.IllegalArgumentException

enum class Hand(val value: Int) {
    ROCK(1),
    PAPER(2),
    SCISSOR(3);

    companion object {
        fun fromLetter(letter: String): Hand {
            return when(letter) {
                "A", "X" -> ROCK
                "B", "Y" -> PAPER
                "C", "Z" -> SCISSOR
                else -> throw IllegalArgumentException()
            }
        }

        fun betterHand(other: Hand): Hand {
            return when(other) {
                ROCK -> PAPER
                PAPER -> SCISSOR
                SCISSOR -> ROCK
            }
        }

        fun worseHand(other: Hand): Hand {
            return when(other) {
                ROCK -> SCISSOR
                PAPER -> ROCK
                SCISSOR -> PAPER
            }
        }
    }
}