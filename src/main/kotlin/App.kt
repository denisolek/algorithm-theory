object Setup {
    const val itemCount = 20
    const val knapsackCapacity = 3000
}

fun main() {
    println("Items count: ${Setup.itemCount}")
    println("Knapsack capacity: ${Setup.knapsackCapacity}")

    val items = Item.generate(Setup.itemCount)
    BruteForce().measure(items, Setup.knapsackCapacity).print()
    Dynamic().measure(items, Setup.knapsackCapacity).print()
}