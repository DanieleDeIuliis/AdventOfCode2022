package day4

object Day4 {
    fun part1(input: String): Int {
        val sections = input.split("\n")
            return sections.count {
                val (firstSectionsRange, secondSectionsRange) =
                    it.split(",")
                val firstExtremes = firstSectionsRange.split("-")
                val firstRange = firstExtremes.first().toInt() .. firstExtremes.last().toInt()
                val secondExtremes = secondSectionsRange.split("-")
                val secondRange = secondExtremes.first().toInt() .. secondExtremes.last().toInt()
                firstRange.isContained(secondRange) || secondRange.isContained(firstRange)
            }
    }

    fun part2(input: String): Int {
        val sections = input.split("\n")
        return sections.count {
            val (firstSectionsRange, secondSectionsRange) =
                it.split(",")
            val firstExtremes = firstSectionsRange.split("-")
            val firstRange = firstExtremes.first().toInt() .. firstExtremes.last().toInt()
            val secondExtremes = secondSectionsRange.split("-")
            val secondRange = secondExtremes.first().toInt() .. secondExtremes.last().toInt()
            firstRange.containsAny(secondRange)
        }
    }

    private fun IntRange.isContained(other: IntRange): Boolean {
        return this.all {
            other.contains(it)
        }
    }

    private fun IntRange.containsAny(other: IntRange): Boolean {
        return this.any {
            other.contains(it)
        }
    }
}