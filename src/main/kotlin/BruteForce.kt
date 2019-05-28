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
