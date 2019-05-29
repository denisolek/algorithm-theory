class Greedy : KnapsackSolver {
    override fun solve(items: Set<Item>, capacity: Int): Set<Item> {
        var capacityUsed = 0
        return items
            .sortedByDescending { it.ratio() }
            .mapNotNull { item ->
                if (capacityUsed + item.weight < capacity) {
                    capacityUsed += item.weight
                    item
                } else null
            }.toSet()
    }
}