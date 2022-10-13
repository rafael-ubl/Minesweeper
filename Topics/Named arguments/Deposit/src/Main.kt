import kotlin.math.pow

fun main() {
    val parameter = readln()
    val value = readln().toInt()
    println(
        when (parameter) {
            "amount" -> compoundInterest(amount = value)
            "percent" -> compoundInterest(percent = value)
            else -> compoundInterest(years = value)
        }
    )
}

fun compoundInterest(amount: Int = 1000, percent: Int = 5, years: Int = 10) =
    (amount * (1 + percent.toDouble() / 100).pow(years)).toInt()

