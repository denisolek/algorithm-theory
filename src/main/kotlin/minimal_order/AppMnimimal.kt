package minimal_order

import powerset

fun main() {
    var elementsCount = 3
    val elements = generateSequence { (elementsCount--).takeIf { it > 0 } }.toList().reversed()
    println("Elements: $elements")
    val powerset = elements.powerset().toMutableList()
    println("Powerset elements: ${powerset.size}")
    var rank = generateSequence(0) { it }.take(powerset.size).toMutableList()
    println("Zero list: $rank")
//    println("Powerset $powerset")
    for (i in 1..powerset.size) {
        println("i: $i")
        rank[i] = rank(powerset[i])
        println("Wynik pośredni r[$i] = ${rank[i]} ")
    }
}

private fun rank(element: Set<Int>, n: Int = 3): Int {
    var r = 0
    for (i in 1..n+1) {
        if (i != 0) {
            r *= 2
            if (i in element) {
                r += 1
            }
        }
    }
    return r
}