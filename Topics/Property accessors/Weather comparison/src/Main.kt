class City(val name: String) {
    companion object {
        const val MIN_TEMPERATURE = -92
        const val MAX_TEMPERATURE = 57
        const val MOSCOW_DEFAULT_TEMP = 5
        const val HANOI_DEFAULT_TEMP = 20
        const val DUBAI_DEFAULT_TEMP = 30
    }

    var degrees: Int = 0
        set(value) {
            field = if (value in MIN_TEMPERATURE..MAX_TEMPERATURE) {
                value
            } else {
                when (name) {
                    "Moscow" -> MOSCOW_DEFAULT_TEMP
                    "Hanoi" -> HANOI_DEFAULT_TEMP
                    "Dubai" -> DUBAI_DEFAULT_TEMP
                    else -> 0
                }
            }
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    // implement comparing here
    val coldestTemperature = minOf(firstCity.degrees, secondCity.degrees, thirdCity.degrees)
    val isSameTemperature =
        firstCity.degrees == secondCity.degrees ||
            secondCity.degrees == thirdCity.degrees ||
            firstCity.degrees == thirdCity.degrees
    println(
        when {
            isSameTemperature -> "neither"
            firstCity.degrees == coldestTemperature -> firstCity.name
            secondCity.degrees == coldestTemperature -> secondCity.name
            else -> thirdCity.name
        }
    )
}