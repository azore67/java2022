package aeroplane

open class NonCrew(firstName: String, lastName:String, val age: Int) :Passenger(firstName, lastName){
    val adultAge = 18
    override fun isAdult(): Boolean = age >= adultAge
    fun getName(): String{
        return "first name: $firstName"
    }

    override fun toString(): String {
       return ""
    }

}