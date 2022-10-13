fun main() {
    val n = readln().toInt()

    val numbers = List(n) { readln().toInt() }

    println(
        if (numbers.size > 1) {
            numbers.sorted()[numbers.size - 1] * numbers.sorted()[numbers.size - 2]
        } else {
            numbers[0]
        }
    )
}