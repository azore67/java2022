package aeroplane

class EconomyClassMember(firstName: String, lastName: String, age: Int):NonCrew(firstName,lastName,age){
    override fun toString(): String {
        return "Economy Class - ${super.toString()}"
    }

}