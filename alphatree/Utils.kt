package alphatree


import java.util.HashSet

object Utils {

    fun newAlphaTree(chars: List<Char>): AlphaTree {
        // TODO: Implement Question 4
        TODO()
    }

    fun newAlphaTree(string: String): AlphaTree {
        return newAlphaTree(object : AbstractList<Char>() {
            override val size: Int
                get() = string.length

            override fun get(index: Int): Char {
                return string[index]
            }
        })
    }

    fun toSet(s: String): Set<Char> {
        return s.toCharArray().toSet()
    }

    fun <A> singleton(x: A): Set<A> {
        val xs = HashSet<A>()
        xs.add(x)
        return xs
    }

    fun <A> isSingleton(xs: Set<A>): Boolean {
        return xs.size == 1
    }

    fun <A> getElem(xs: Set<A>): A {
        require(isSingleton(xs)) { "Set must be a singleton" }
        return xs.first()
    }
}
