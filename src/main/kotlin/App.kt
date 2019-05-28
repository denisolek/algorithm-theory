fun main() {
    val backpackCapacity = 1000
    val items = Item.generate(20)
    BruteForce().measure(items, backpackCapacity).print()
}