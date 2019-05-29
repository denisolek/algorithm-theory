import java.util.concurrent.TimeUnit

class Solution(
    val method: String,
    val resultSet: Set<Item>,
    val time: Long
) {
    fun print() {
        println("=================================")
        println("Method: $method")
        println("Time nano: $time nano")
        println("Time ms: ${TimeUnit.NANOSECONDS.toMillis(time)} ms")
        println("Total value: ${resultSet.value()}")
        println("Total weight: ${resultSet.weight()}")
        println("Items:")
        resultSet.print()
    }
}