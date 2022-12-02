package day2

import day2.Hand.*
import day2.Result.*

object Day2 {
    fun part1(input: String): Int {
        return input.split("\n").sumOf { line ->
            val (opponent, player) = line.split(" ")

            computeResult(Hand.fromLetter(player), Hand.fromLetter(opponent))
        }
    }

    fun part2(input: String): Int {
        return input.split("\n").sumOf { line ->
            val (opponent, player) = line.split(" ")
            val opponentHand = Hand.fromLetter(opponent)
            val playerHand = getHand(player, opponentHand)

            computeResult(playerHand, opponentHand)
        }
    }

    private fun getHand(letter: String, opponent: Hand): Hand {
        return when(Result.from(letter)) {
            LOSE -> Hand.worseHand(opponent)
            DRAW -> opponent
            WIN -> Hand.betterHand(opponent)
        }
    }

    private fun computeResult(player: Hand, opponent: Hand) =
        computePartialScore(player, opponent).value + player.value

    private fun computePartialScore(player: Hand, opponent: Hand): Result {
        if(player == opponent) return DRAW

        return if(player.isBetterThan(opponent)) WIN else LOSE
    }
}
