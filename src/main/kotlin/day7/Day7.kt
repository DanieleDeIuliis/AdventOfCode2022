package day7

import day7.Type.DIRECTORY
import day7.Type.FILE

private const val SPACE_NEEDED = 30_000_000
private const val TOTAL_AVAILABLE_SPACE = 70_000_000


object Day7 {
    fun part1(input: String): Int {
        val commands = input.split("\n").drop(1)
        val root = buildTree(commands)
        postOrderVisit(root)
        return sumSize(root)
    }

    private fun buildTree(commands: List<String>): Node {
        val root = Node("/", DIRECTORY)
        var current = root
        commands.forEach {
            val trimmed = it.trim()
            if (trimmed.isCommand()) {
                current = when {
                    trimmed == "$ cd .." -> current.parent!!
                    trimmed.startsWith("$ cd") -> current.children.single { child -> child.name == trimmed.split(" ")[2] }
                    else -> return@forEach
                }
            } else {
                if (trimmed.startsWith("dir")) {
                    val name = trimmed.split(" ")[1]
                    current.children.add(Node(name, DIRECTORY, parent = current))
                } else {
                    val (size, name) = trimmed.split(" ")
                    current.children.add(Node(name, FILE, size.toInt(), current))
                }
            }
        }
        return root
    }

    private fun postOrderVisit(node: Node) {
        if(node.children.isEmpty()) return
        node.children.forEach { postOrderVisit(it) }
        if(node.type == DIRECTORY) {
            node.size = node.children.sumOf { it.size }
        }
    }

    private fun sumSize(node: Node): Int {
        if(node.children.isEmpty()) return 0
        val currentSize = if (node.type == DIRECTORY && node.size <= 100_000) {
            node.size
        } else {
            0
        }
        return currentSize + node.children.sumOf { sumSize(it) }
    }

    private fun String.isCommand(): Boolean {
        return startsWith("$")
    }

    fun part2(input: String): Int {
        val commands = input.split("\n").drop(1)
        val root = buildTree(commands)
        postOrderVisit(root)
        val minSizeNeeded = SPACE_NEEDED - (TOTAL_AVAILABLE_SPACE - root.size)
        val directories = mutableListOf<Int>()
        findDirectorySize(root, minSizeNeeded, directories)
        return directories.min()
    }

    private fun findDirectorySize(node: Node, minSizeNeeded : Int, directories : MutableList<Int>) {
        if(node.children.isEmpty()) return
        if (node.type == DIRECTORY && node.size >= minSizeNeeded) {
            directories.add(node.size)
        }
        node.children.forEach { findDirectorySize(it, minSizeNeeded, directories) }
    }

}

data class Node(
    val name: String,
    val type: Type,
    var size: Int = 0,
    val parent: Node? = null,
    val children: MutableList<Node> = mutableListOf()
)

enum class Type {
    FILE,
    DIRECTORY
}