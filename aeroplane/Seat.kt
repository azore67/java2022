package aeroplane
class Seat(val row: Int, val letter: Char) {
// variable for starting row, ending row, starting letter, ending letter
    private val startRow = 1
    private val endRow = 50
    private val startLetter = 'A'
    private val endLetter = 'F'
    private val exitRowArray = intArrayOf(1,10,30)


    val CREW_FIRST_ROW = startRow
    val CREW_LAST_ROW = startRow
    val BUSINESS_FIRST_ROW = 2
    val BUSINESS_LAST_ROW  = 15
    val ECONOMY_FIRST_ROW = 16
    val ECONOMY_LAST_ROW  = endRow


    private val CREW_START = Seat(CREW_FIRST_ROW,startLetter)
    private val CREW_LAST  = Seat(CREW_LAST_ROW,startLetter)
    private val BUSINESS_FIRST = Seat(BUSINESS_FIRST_ROW, startLetter)
    private val BUSINESS_LAST  = Seat(BUSINESS_LAST_ROW, endLetter)
    private val ECONOMY_FIRST = Seat(ECONOMY_FIRST_ROW, startLetter)
    private val ECONOMY_LAST = Seat(ECONOMY_LAST_ROW, endLetter)


    init {
        if (row !in startRow..endRow || letter !in startLetter..endLetter ) {
            throw IllegalArgumentException("Invalid Seat Parameter")
        }

    }
    override fun toString(): String {
        return "%02d%c".format(row,letter)
    }
     fun isEmergencyExit(): Boolean {
       return row in exitRowArray
    }
     fun compare(other:Seat): Boolean {
        return this.row < other.row || this.row == other.row && this.letter < other.letter
    }

    fun hasNext(): Boolean {
        return (row < endRow || (row == endRow && letter < endLetter ))
    }



//     the following is to give info of the next seat

    fun next(): Seat {
        if (!hasNext()) {
            throw NoSuchElementException("this is the last seat")
        }
        else {
            if (letter == endLetter) {
                return Seat( row+1, startLetter)
            }
            return Seat(row, letter + 1)
        }

    }
    override fun equals(other: Any?): Boolean {
        return (other is Seat && this.row == other.row && this.letter == other.letter)
    }
}

fun main() {

}