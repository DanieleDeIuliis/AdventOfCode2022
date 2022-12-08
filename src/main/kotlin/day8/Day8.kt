package day8

object Day8 {
    fun part1(input: String): Int {
        val rows = input.split("\n").map {
            it.toCharArray().map(Char::digitToInt)
        }

        val cols = List(rows[0].size) {col ->
            List(rows[0].size) { row ->
                rows[row][col]
            }
        }

        var count = 0
        rows.forEachIndexed { rowIndex, rows ->
            rows.forEachIndexed { colIndex, _ ->
                val left = isVisibleOnLeft(rows, colIndex)
                val right = isVisibleOnRight(rows, colIndex)
                val up = isVisibleOnTop(cols[colIndex], rowIndex)
                val down = isVisibleOnBottom(cols[colIndex], rowIndex)
                if(left || right || up || down) count++
            }
        }

        return count
    }

    fun isVisibleOnLeft(row: List<Int>, index: Int): Boolean {
        if(index == 0) return true
        val value = row[index]
        return row.take(index).all { it < value }
    }

    fun isVisibleOnRight(row: List<Int>, index: Int): Boolean {
        if(index == row.size - 1) return true
        val value = row[index]
        return row.drop(index + 1).all { it < value }

    }

    fun isVisibleOnTop(col: List<Int>, index: Int): Boolean {
        if(index == 0) return true
        val value = col[index]
        return col.take(index).all { it < value }
    }

    fun isVisibleOnBottom(col: List<Int>, index: Int): Boolean {
        if(index == col.size - 1) return true
        val value = col[index]
        return col.drop(index + 1).all { it < value }

    }

    fun part2(input: String): Int {
        val rows = input.split("\n").map {
            it.toCharArray().map(Char::digitToInt)
        }

        val cols = List(rows[0].size) {col ->
            List(rows[0].size) { row ->
                rows[row][col]
            }
        }
        var max = 0
        rows.forEachIndexed { rowIndex, rows ->
            rows.forEachIndexed { colIndex, _ ->
                val left = countLeft(rows, colIndex)
                val right = countRight(rows, colIndex)
                val up = countTop(cols[colIndex], rowIndex)
                val down = countBottom(cols[colIndex], rowIndex)
                max = maxOf(max, left * right * up * down)
            }
        }

        return max
    }

    fun countLeft(row: List<Int>, index: Int): Int {
        if(index == 0) return 0
        val value = row[index]
        val firstIndex = row.take(index).reversed().indexOfFirst { it >= value }
        return if(firstIndex == -1) {
            index
        }else {
            firstIndex + 1
        }
    }

    fun countRight(row: List<Int>, index: Int): Int {
        if(index == row.size - 1) return 0
        val value = row[index]
        val firstIndex = row.drop(index + 1).indexOfFirst { it >= value }
        return if(firstIndex == -1) {
            row.size - 1 - index
        } else {
            firstIndex + 1
        }
    }

    fun countTop(col: List<Int>, index: Int): Int {
        if(index == 0) return 0
        val value = col[index]
        val firstIndex = col.take(index).reversed().indexOfFirst { it >= value }
        return if(firstIndex == -1) {
            index
        }else {
            firstIndex + 1
        }
    }

    fun countBottom(col: List<Int>, index: Int): Int {
        if(index == col.size - 1) return 0
        val value = col[index]
        val firstIndex = col.drop(index + 1).indexOfFirst { it >= value }
        return if(firstIndex == -1) {
            col.size - 1 - index
        } else {
            firstIndex + 1
        }

    }
}