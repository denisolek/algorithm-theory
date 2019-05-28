class Solution(
    val method: String,
    val resultSet: Set<Item>,
    val time: Long
) {
    fun print() {
        println("Method: $method")
        println("Time: $time")
        println("Value: ${resultSet.value()}")
    }
}