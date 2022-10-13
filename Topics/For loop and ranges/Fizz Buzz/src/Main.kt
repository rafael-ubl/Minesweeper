fun main() {
    val minLimit = readln().toInt()
    val maxLimit = readln().toInt()

    for (number in minLimit..maxLimit) {
        println(
            when {
                number % 3 == 0 && number % 5 == 0 -> "FizzBuzz"
                number % 3 == 0 -> "Fizz"
                number % 5 == 0 -> "Buzz"
                else -> number
            }
        )
    }
}