interface KnapsackSolver {
    fun solve(items: Set<Item>, capacity: Int): Set<Item>
    fun measure(items: Set<Item>, capacity: Int): Solution {
        val startTime = System.currentTimeMillis()
        val set = solve(items, capacity)
        return Solution(
            method = this.javaClass.name,
            resultSet = set,
            time = System.currentTimeMillis() - startTime
        )
    }
}