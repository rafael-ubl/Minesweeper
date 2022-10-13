fun main() {
    val number = readln().toInt()

    println(
        when {
            number == 0 -> "zero"
            number > 0 -> "positive"
            else -> "negative"
        }
    )
}