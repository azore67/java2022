package aeroplane

class BusinessClassMember(firstName: String, lastName: String, age: Int, val luxury: Luxury):NonCrew(firstName,lastName,age){
    override fun toString(): String {
        return "Business Class: ${getName()}"
    }
}