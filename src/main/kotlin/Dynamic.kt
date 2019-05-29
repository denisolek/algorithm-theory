class Dynamic : KnapsackSolver {
    override fun solve(items: Set<Item>, capacity: Int): Set<Item> {
        val itemsList = items.toList()
        val itemsCount = itemsList.count()

        val matrix = Array(itemsCount + 1) { IntArray(capacity + 1) }

        // init first line with 0
        for (i in 0..itemsCount)
            matrix[i][0] = 0

        for (i in 1..itemsCount) {
            // we iterate on each capacity
            for (j in 0..capacity) {
                if (itemsList[i - 1].weight > j)
                    matrix[i][j] = matrix[i - 1][j]
                else
                // we maximize value at this rank in the matrix
                    matrix[i][j] =
                        Math.max(matrix[i - 1][j], matrix[i - 1][j - itemsList[i - 1].weight] + itemsList[i - 1].value)
            }
        }
        return localizeSetFromMatrix(itemsCount, capacity, matrix, itemsList)
    }

    private fun localizeSetFromMatrix(
        itemsCount: Int,
        capacity: Int,
        matrix: Array<IntArray>,
        itemsList: List<Item>
    ): MutableSet<Item> {
        var countPos = itemsCount
        var capacityPos = capacity
        val set = mutableSetOf<Item>()

        while (countPos > 0 && capacityPos > 0) {
            if (matrix[countPos][capacityPos] != matrix[countPos - 1][capacityPos]) {
                set.add(itemsList[countPos - 1])
                capacityPos -= itemsList[countPos - 1].weight
                countPos -= 1
            } else {
                countPos -= 1
            }
        }
        return set
    }
}
