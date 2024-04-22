
package aeroplane

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

class SeatAllocator {
    private val allocation = mutableMapOf<Seat, Passenger>()
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

    object PassengerType {
        const val CREW = "crew"
        const val BUSINESS = "business"
        const val ECONOMY = "economy"
    }
    fun countAdults(passengers:Set<Passenger>): Int {
        return passengers.count{it.isAdult()}
    }

    override fun toString(): String {
        val allocatedSeatsSortedByName = allocation.keys
            .distinct()
            .sortedBy { it.toString() }
            .toList()

        val result = StringBuilder()
        for (seat in allocatedSeatsSortedByName) {
            result.append("$seat -> ${allocation[seat]}\n")
        }
        return result.toString()
    }

    private fun allocateInRange(passenger: Passenger, first: Seat, last: Seat) {

        var currentSeat = first
        while (currentSeat.compare(last)) {
            if (allocation[currentSeat] == null && passenger.isAdult() || !currentSeat.isEmergencyExit()) {
                allocation[currentSeat] = passenger
            }
            throw AllocationNotPossibleException("cannot allocate passenger seat")

            }
        currentSeat = currentSeat.next()


    }

    @Throws(MalformedDataException::class, IOException::class)
    private fun readStringValue(br: BufferedReader): String {
        val result = br.readLine() ?: throw MalformedDataException()
        return result
    }
    @Throws(MalformedDataException::class, IOException::class)
    private fun readIntValue(br: BufferedReader): Int {
        try {
            return readStringValue(br).toInt()
        } catch (e: NumberFormatException) {
            throw MalformedDataException()
        }
    }
    @Throws(MalformedDataException::class, IOException::class)
    private fun readLuxuryValue(br: BufferedReader): Luxury {
        try {
            return Luxury.valueOf(readStringValue(br))
        } catch (e: IllegalArgumentException) {
            throw MalformedDataException()
        }
    }
    @Throws(IOException::class, AllocationNotPossibleException::class)
    fun allocate(filename: String) {
        BufferedReader(FileReader(filename)).use { br ->
            var line: String?
            while (br.readLine().also { line = it } != null) {
                try {
                    when (line) {
                        PassengerType.CREW -> allocateCrew(br)
                        PassengerType.BUSINESS -> allocateBusiness(br)
                        PassengerType.ECONOMY -> allocateEconomy(br)

                        else -> throw MalformedDataException()
                    }
                } catch (e: MalformedDataException) {
                    throw RuntimeException("Malformed Line of input: $line", e)
                }
            }
        }
    }
    @Throws(IOException::class, MalformedDataException::class, AllocationNotPossibleException::class)
    private fun allocateCrew(br: BufferedReader) {
        val firstName = readStringValue(br)
        val lastName = readStringValue(br)
        val crewMember = Crew(firstName, lastName)

        allocateInRange(crewMember, CREW_START, CREW_LAST)

    }
    @Throws(IOException::class, MalformedDataException::class, AllocationNotPossibleException::class)
    private fun allocateBusiness(br: BufferedReader) {
        val firstName = readStringValue(br)
        val lastName = readStringValue(br)
        val age = readIntValue(br)
        val luxury = readLuxuryValue(br)
        val businessClassMember = BusinessClassMember(firstName, lastName, age, luxury)
        allocateInRange(businessClassMember, BUSINESS_FIRST, BUSINESS_LAST)
    }
    @Throws(IOException::class, MalformedDataException::class, AllocationNotPossibleException::class)
    private fun allocateEconomy(br: BufferedReader) {
        val firstName = readStringValue(br)
        val lastName = readStringValue(br)
        val age = readIntValue(br)
        val economyClassMember = EconomyClassMember(firstName, lastName, age)
        allocateInRange(economyClassMember, ECONOMY_FIRST,ECONOMY_LAST)
    }






}











