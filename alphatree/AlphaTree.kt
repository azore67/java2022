package alphatree
import java.util.*

class AlphaTree {
     var charSet: Set<Char>? = null
     var frequency = 0
     var leftTree: AlphaTree? = null
     var rightTree: AlphaTree? = null

    constructor() {
        charSet = Collections.emptySet()
        frequency = 0
        leftTree = null
        rightTree = null
    }

    constructor(c: Char, weight: Int) {
        charSet = setOf(c)
        frequency = weight
        leftTree = null
        rightTree = null
    }
    constructor(lt: AlphaTree, rt: AlphaTree) {
        charSet = lt.chars()?.union(rt.chars()?: emptySet())
        frequency = lt.freq() + rt.freq()
        leftTree = lt
        rightTree = rt
    }
    fun isEmpty(): Boolean {
        return charSet!!.isEmpty()
    }
    fun isSingleton(): Boolean {
        return charSet!!.size == 1
    }
    fun left(): AlphaTree? {
        return leftTree
    }
    fun right(): AlphaTree? {
        return rightTree
    }
    fun chars(): Set<Char>? {
        return charSet
    }
    fun freq(): Int {
        return frequency
    }
}
