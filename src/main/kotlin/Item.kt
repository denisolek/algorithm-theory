class Item(
    val id: Int,
    val value: Int,
    val weight: Int
) {
    companion object {
        fun generate(count: Int): Set<Item> = MutableList(count) {
            val value = Setup.valueRange
            val weight = Setup.weightRange
            Item(
                id = it + 1,
                value = (value.first..value.second).random(),
                weight = (weight.first..weight.second).random()
            )
        }.toSet()
    }

    fun ratio() = this.value.toDouble() / this.weight.toDouble()

    fun print() = println("    Item $id v:${this.value} w:${this.weight}")
}

fun Set<Item>.weight() = this.sumBy { it.weight }

fun Set<Item>.value() = this.sumBy { it.value }

fun Set<Item>.print() = this.sortedBy { it.ratio() }.forEach { it.print() }
