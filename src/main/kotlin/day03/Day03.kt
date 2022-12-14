package day03

import readInput

fun Char.toAocCode(): Int {
    return if (isLowerCase()) {
        code - 96
    } else if (isUpperCase()) {
        code - 38
    } else 0
}

fun String.toHalves(): Pair<String, String> =
    substring(0, length / 2) to substring(length / 2)

fun part1(input: List<String>): Int =
    input.sumOf {
        val halves = it.toHalves()
        halves.first
            .toSet()
            .intersect(halves.second.toSet())
            .first()
            .toAocCode()
    }

fun part2(input: List<String>): Int =
    input.chunked(3).sumOf {
        val first = it.first().toSet()
        val second = it[1].toSet()
        val third = it.last().toSet()
        val badge = (first.intersect(second)).intersect(third).first()
        badge.toAocCode()
    }

fun main() {

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
