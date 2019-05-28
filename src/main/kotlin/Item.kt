class Item(
    val name: String,
    val value: Int,
    val weight: Int
) {
    companion object {
        fun generate(count: Int): Set<Item> = MutableList(count) {
            Item(name = "    Item ${it + 1}", value = (1..100).random(), weight = (300..1000).random())
        }.toSet()
    }

    fun print() = println("${this.name} v:${this.value} w:${this.weight}")
}

fun Set<Item>.weight() = this.sumBy { it.weight }

fun Set<Item>.value() = this.sumBy { it.value }

fun Set<Item>.print() = this.forEach { it.print() }
