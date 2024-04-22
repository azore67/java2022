package aeroplane

open class Crew(firstName:String, lastName: String):Passenger(firstName, lastName) {
    val areCrewAdult= true
    override fun isAdult(): Boolean = areCrewAdult
    fun getName(): String{
        return "first name: $firstName, last name : $surname"
    }
    override fun toString(): String {
        return "Crew - ${getName()}"
    }

}