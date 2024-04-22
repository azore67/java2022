package aeroplane

abstract class Passenger(val firstName: String, val surname : String){
    abstract fun isAdult(): Boolean
    abstract override fun toString(): String

}
