//
//package aeroplane
//
//import java.io.BufferedReader
//import java.io.FileReader
//import java.io.IOException
//
//class SeatAllocator {
//    private val allocation = mutableMapOf<Seat, Passenger>()
//
//    object PassengerType {
//        const val CREW = "crew"
//        const val BUSINESS = "business"
//        const val ECONOMY = "economy"
//    }
//    fun countAdults(passengers:Set<Passenger>): Int {
//        return passengers.count{it.isAdult()}
//    }
//
//    override fun toString(): String {
//        val allocatedSeatsSortedByName = allocation.keys
//            .distinct()
//            .sortedBy { it.toString() }
//            .toList()
//
//        val result = StringBuilder()
//        for (seat in allocatedSeatsSortedByName) {
//            result.append("$seat -> ${allocation[seat]}\n")
//        }
//        return result.toString()
//    }
//
//    private fun allocateInRange(passenger: Passenger, first: Seat, last: Seat) {
//
//        var currentSeat = first
//        while (currentSeat.compare(last)) {
//            if (allocation[currentSeat] == null && passenger.isAdult() || !currentSeat.isEmergencyExit()) {
//                allocation[currentSeat] = passenger
//            }
//            throw AllocationNotPossibleException("cannot allocate passenger seat")
//
//            }
//        currentSeat = currentSeat.next()
//
//
//    }
//
//    @Throws(MalformedDataException::class, IOException::class)
//    private fun readStringValue(br: BufferedReader): String {
//        val result = br.readLine() ?: throw MalformedDataException()
//        return result
//    }
//    @Throws(MalformedDataException::class, IOException::class)
//    private fun readIntValue(br: BufferedReader): Int {
//        try {
//            return readStringValue(br).toInt()
//        } catch (e: NumberFormatException) {
//            throw MalformedDataException()
//        }
//    }
//    @Throws(MalformedDataException::class, IOException::class)
//    private fun readLuxuryValue(br: BufferedReader): Luxury {
//        try {
//            return Luxury.valueOf(readStringValue(br))
//        } catch (e: IllegalArgumentException) {
//            throw MalformedDataException()
//        }
//    }
//    @Throws(IOException::class, AllocationNotPossibleException::class)
//    fun allocate(filename: String) {
//        BufferedReader(FileReader(filename)).use { br ->
//            var line: String?
//            while (br.readLine().also { line = it } != null) {
//                try {
//                    when (line) {
//                        PassengerType.CREW -> allocateCrew(br)
//                        PassengerType.BUSINESS -> allocateBusiness(br)
//                        PassengerType.ECONOMY -> allocateEconomy(br)
//
//                        else -> throw MalformedDataException()
//                    }
//                } catch (e: MalformedDataException) {
//                    throw RuntimeException("Malformed Line of input: $line", e)
//                }
//            }
//        }
//    }
//    @Throws(IOException::class, MalformedDataException::class, AllocationNotPossibleException::class)
//    private fun allocateCrew(br: BufferedReader) {
//        val firstName = readStringValue(br)
//        val lastName = readStringValue(br)
//        val age = readIntValue(br)
//        val crewMember = CrewMember(firstName, lastName, age)
//        val first = Seat(1,'A')
//        val last = Seat (1, 'F')
//        allocateInRange(crewMember, first, last)
//
//    }
//    @Throws(IOException::class, MalformedDataException::class, AllocationNotPossibleException::class)
//    private fun allocateBusiness(br: BufferedReader) {
//        val firstName = readStringValue(br)
//        val lastName = readStringValue(br)
//        val age = readIntValue(br)
//        val luxury = readLuxuryValue(br)
//        val businessClassMember = BusinessClassPassenger(firstName, lastName, age, luxury)
//        val first = Seat(2, 'A')
//        val last = Seat(15,'F')
//        allocateInRange(businessClassMember, first, last)
//    }
//    @Throws(IOException::class, MalformedDataException::class, AllocationNotPossibleException::class)
//    private fun allocateEconomy(br: BufferedReader) {
//        val firstName = readStringValue(br)
//        val lastName = readStringValue(br)
//        val age = readIntValue(br)
//        val economyClassMember = EconomyClassPassenger(firstName, lastName, age)
//        val first = Seat(16,'A')
//        val last = Seat(50,'F')
//        allocateInRange(economyClassMember, first,last)
//    }
//
//
//
//
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
