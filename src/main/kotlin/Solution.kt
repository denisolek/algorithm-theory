class Solution(
    val method: String,
    val resultSet: Set<Item>,
    val time: Long
) {
    fun print() {
        println("=================================")
        println("Method: $method")
        println("Time: $time ms")
        println("Total value: ${resultSet.value()}")
        println("Total weight: ${resultSet.weight()}")
        println("Items:")
        resultSet.print()
    }
}