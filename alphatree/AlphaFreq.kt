package alphatree

class AlphaFreq {
     var charMap = ('a'..'z').associateWithTo(mutableMapOf()) {0}
    constructor() {
    }

    constructor(cs:List<Char>) {
        for (c in cs) {
            charMap[c] = charMap[c]!! + 1
        }

    }
    fun isEmpty():Boolean {
        return size() == 0
    }
    fun size(): Int {
        return this.charMap.values.sum()
    }
    fun get(c: Char): Int {
        return charMap[c]!!
    }
    fun add(c:Char) {
        charMap[c] = charMap[c]!! + 1

    }
    fun reset() {
        charMap = ('a'..'z').associateWithTo(mutableMapOf()) {0}

    }





}