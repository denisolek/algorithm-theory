object Setup {
    const val itemCount = 20
    const val knapsackCapacity = 100
    val weightRange = 1 to 50
    val valueRange = 1 to 100
}

fun main() {
    println("Items count: ${Setup.itemCount}")
    println("Knapsack capacity: ${Setup.knapsackCapacity}")

    val items = Item.generate(Setup.itemCount)
    BruteForce().measure(items, Setup.knapsackCapacity).print()
    Dynamic().measure(items, Setup.knapsackCapacity).print()
    Greedy().measure(items, Setup.knapsackCapacity).print()
}