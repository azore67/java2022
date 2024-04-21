package alphatree
import java.util.PriorityQueue

class AlphaTreeQueue {
    private val pq = PriorityQueue<AlphaTree> { t1, t2 ->
        if (t1.frequency == t2.frequency) {
            // If frequencies are equal, compare based on insertion order
            0
        } else {
            // Otherwise, compare based on frequency (lower frequency has higher priority)
            t1.frequency.compareTo(t2.frequency)
        }
    }
    constructor() {
    }
    constructor(freqs: AlphaFreq) {
        for (entry in freqs.charMap) {
            pq.add( AlphaTree(entry.key, entry.value))
        }
    }
    fun add(t: AlphaTree) {
        pq.add(t)
    }
    fun addAll(freqs: AlphaFreq) {
        for (entry in freqs.charMap) {
            pq.add( AlphaTree(entry.key, entry.value))
        }
    }
    fun peek(): AlphaTree? {
        return pq.peek()
    }
    fun poll(): AlphaTree? {
        return pq.poll()
    }
    fun size(): Int {
        return pq.size
    }
}