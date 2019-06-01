package minimal_order

import java.util.*

object MinimalOrder {

    private fun rank(permutation: MutableList<Int>): Int {
        val size = permutation.size

        if (size < 2)
            return 0

        val removedNumber = getLower(permutation)
        val lowerRank = rank(permutation)

        return if (lowerRank % 2 == 0) {
            size * lowerRank + size - removedNumber
        } else size * lowerRank + removedNumber - 1

    }

    private fun unrank(index: Int, sizeOfPermutation: Int): MutableList<Int> {
        if (sizeOfPermutation < 2)
            return ArrayList(listOf(1))

        if (sizeOfPermutation == 2) {
            return if (index == 0) {
                ArrayList(Arrays.asList(1, 2))
            } else {
                ArrayList(Arrays.asList(2, 1))
            }
        }

        val lowerIndex = index / sizeOfPermutation
        val indexHelper = index - sizeOfPermutation * lowerIndex
        val lowerPermutation = unrank(lowerIndex, sizeOfPermutation - 1)
        if (lowerIndex % 2 == 0) {
            lowerPermutation.add(sizeOfPermutation - indexHelper - 1, sizeOfPermutation)
        } else {
            lowerPermutation.add(indexHelper, sizeOfPermutation)
        }

        return lowerPermutation

    }

    private fun getLower(permutation: MutableList<Int>): Int {
        val index = permutation.indexOf(permutation.size)

        if (!permutation.contains(permutation.size)) {
            throw IllegalArgumentException("No value in permutation: " + permutation.size)
        }
        permutation.remove(permutation.size)
        return permutation.subList(0, index).size + 1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var elementsCount = 3
        val elements = generateSequence { (elementsCount--).takeIf { it > 0 } }.toList().reversed()
        println("Elements: $elements")
        println("Permutations: ${elements.permutations()}")
        elements.permutations().map {
            println("Permutation: $it Rank: ${rank(it.toMutableList())} Unrank: ${unrank(rank(it.toMutableList()), elements.size)}")
            it to rank(it.toMutableList())
        }
    }

}

