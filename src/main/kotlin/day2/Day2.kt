package day2

import day2.Hand.*

object Day2 {
    fun part1(input: String): Int {
        return input.split("\n").map { line ->
            val hands = line.split(" ")
            val opponent = Hand.fromLetter(hands.first())
            val player = Hand.fromLetter(hands.last())

            computeResult(player, opponent)
        }.sum()
    }

    fun part2(input: String): Int {
        return 0
    }

    private fun computeResult(player: Hand, opponent: Hand) =
        computePartialScore(player, opponent) + player.value

    private fun computePartialScore(player: Hand, opponent: Hand): Int {
        if(player == opponent) return 3

        return when (player) {
            ROCK -> if (opponent == SCISSOR) 6 else 0
            PAPER -> if (opponent == ROCK) 6 else 0
            SCISSOR -> if (opponent == PAPER) 6 else 0
        }
    }
}