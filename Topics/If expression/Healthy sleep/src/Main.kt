fun main() {
    val minHoursOfSleepA = readln().toInt()
    val maxHoursOfSleepB = readln().toInt()
    val hoursSleptH = readln().toInt()

    if (hoursSleptH in minHoursOfSleepA..maxHoursOfSleepB) {
        println("Normal")
    } else if (hoursSleptH < minHoursOfSleepA) {
        println("Deficiency")
    } else {
        println("Excess")
    }
}