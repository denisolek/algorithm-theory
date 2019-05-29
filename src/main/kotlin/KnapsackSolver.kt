interface KnapsackSolver {
    fun solve(items: Set<Item>, capacity: Int): Set<Item>

    fun measure(items: Set<Item>, capacity: Int): Solution {
        val startTime = System.nanoTime()
        val set = solve(items, capacity)
        return Solution(
            method = this.javaClass.name,
            resultSet = set,
            time = System.nanoTime() - startTime
        )
    }
}