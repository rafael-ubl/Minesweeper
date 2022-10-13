import kotlin.math.pow
import kotlin.math.sqrt

private const val PI: Double = 3.14

fun main() {
    val roomType = readln()

    println(
        when (roomType) {
            "triangle" -> calculateArea(roomType, readln().toDouble(), readln().toDouble(), readln().toDouble())
            "rectangle" -> calculateArea(roomType, readln().toDouble(), readln().toDouble())
            "circle" -> calculateArea(roomType, readln().toDouble())
            else -> "Error"
        }
    )
}

fun calculateArea(roomType: String, a: Double, b: Double = 0.0, c: Double = 0.0): Double = when (roomType) {
    "triangle" -> 0.25 * sqrt((a + b + c) * (-a + b + c) * (a - b + c) * (a + b - c))
    "rectangle" -> a * b
    "circle" -> PI * a.pow(2.0)
    else -> 0.0
}