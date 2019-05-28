class BruteForce : KnapsackSolver {
    override fun solve(items: Set<Item>, capacity: Int): Set<Item> {
        var bestValue = 0
        var bestSet = emptySet<Item>()
        val powerSet = items.powerset()
        powerSet.forEach {
            if (it.value() > bestValue && it.weight() <= capacity) {
                bestValue = it.value()
                bestSet = it
            }
        }
        return bestSet
    }
}

fun <T> Collection<T>.powerset(): Set<Set<T>> = powerset(this, setOf(setOf()))

private tailrec fun <T> powerset(left: Collection<T>, acc: Set<Set<T>>): Set<Set<T>> = when {
    left.isEmpty() -> acc
    else ->powerset(left.drop(1), acc + acc.map { it + left.first() })
}