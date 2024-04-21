package aeroplane
data class Seat(val row: Int, val letter: Char) {
    init {
        if (row < 1 || row > 26) {
            throw IllegalArgumentException("Row number must be between 1 and 26")
        }
        if (!letter.isLetter() || letter !in 'A'..'Z') {
            throw IllegalArgumentException("aeroplane.Seat letter should be between A and Z")
        }
    }
    override fun toString(): String {
        val number =
            if (row <=9){
                "0$row"
        }
        else {
            row.toString()
            }
        return "number$letter"
    }
     fun isEmergencyExit(): Boolean {
       return (row == 1 || row == 10 || row == 30)
    }
     fun compare(other:Seat): Boolean {
        return this.row < other.row || this.row == other.row && this.letter < other.letter
    }

     fun next(): Seat {
        if (row == 50 && letter == 'F') {
            throw NoSuchElementException("this is the last seat")
        }
        else {
            if (letter == 'F') {
                return Seat( row+1, 'A')
            }
            return Seat(row, letter + 1)
        }

    }
}