enum class DaysOfTheWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

fun main() {
    for (days in DaysOfTheWeek.values()) {
        println(days.name)
    }
}
