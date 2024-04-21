package aeroplane

class Crew(firstName:String, lastName: String):Passenger(firstName, lastName) {
    val areCrewAdult= true
    override fun isAdult(): Boolean = areCrewAdult
}