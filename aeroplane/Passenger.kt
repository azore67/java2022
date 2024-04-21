package aeroplane

abstract class Passenger(val firstName: String, val surname : String, val age: Int){
    abstract fun passengerType():String
    override fun toString():String {
        val type = passengerType()
        return "$type: $firstName $surname"
    }
    open fun isAdult(): Boolean {
        return age >= 18
    }

}
class CrewMember(firstName: String, surname: String, age: Int): Passenger(firstName, surname, age) {
    override fun passengerType(): String {
        return "Crew"
    }
}
class BusinessClassPassenger(firstName: String, surname: String, age:Int, val luxury: Luxury): Passenger(firstName, surname, age) {


    override fun passengerType(): String {
        return "Business Class"
    }

    override fun toString(): String {
        return "${super.toString()},$age,aeroplane.Luxury: $luxury"
    }
}
class EconomyClassPassenger(firstName: String, surname: String, age: Int): Passenger(firstName, surname, age) {

    override fun passengerType(): String{
        return "Economy Class"
    }
    override fun toString(): String {
        return "${super.toString()},$age"
    }

}

