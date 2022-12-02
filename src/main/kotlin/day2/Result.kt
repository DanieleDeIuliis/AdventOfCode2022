package day2

import java.lang.IllegalArgumentException

enum class Result(val value: Int) {
    WIN(6),
    DRAW(3),
    LOSE(0);

    companion object {
        fun from(letter: String): Result {
            return when(letter) {
                "X" -> LOSE
                "Y" -> DRAW
                "Z" -> WIN
                else -> throw IllegalArgumentException()
            }
        }
    }
}