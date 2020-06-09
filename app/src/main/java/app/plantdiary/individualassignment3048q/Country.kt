package app.plantdiary.individualassignment3048q

data class Country(val code: String, val name: String) {
    override fun toString(): String {
        return "$name $code"
    }
}
