package day10

object Day10 {
    fun part1(input: String): Int {
        var numberOfCycles = 0
        var valueOfRegister = 1
        var currentCycleToMultiply = 20
        var result = 0
        val operations = input.split("\n").flatMap {
            if(it.trim() == "noop") {
                listOf(Operation())
            } else {
                listOf(Operation(), Operation(it.trim().split(" ").last().toInt()))
            }
        }

        operations.forEach {
            numberOfCycles += 1
            if (numberOfCycles == currentCycleToMultiply) {
                result += currentCycleToMultiply * valueOfRegister
                currentCycleToMultiply += 40
            }
            valueOfRegister += it.toAdd
        }
        if((numberOfCycles - 20) % 40 == 0) {
            result += currentCycleToMultiply * valueOfRegister
        }
        return result
    }

    fun part2(input: String): Int {
        return 124
    }
}

data class Operation(val toAdd: Int = 0) {}