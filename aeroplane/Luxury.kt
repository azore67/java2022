package aeroplane

enum class Luxury {
    CHAMPAGNE, TRUFFLES, STRAWBERRIES;

    override fun toString(): String {
        return super.toString().toLowerCase();
    }
}