fun main() {
    val amountOfInputs = readln().toInt()

    var isAscendingOrder = true

    val numbers = mutableListOf<Int>()

    for (i in 1..amountOfInputs) {
        val number = readln().toInt()
        numbers.add(number)
    }

    for (n in 0 until numbers.size - 1) {
        if (numbers[n] > numbers[n + 1]) {
            isAscendingOrder = false
        }
    }

    println(if (isAscendingOrder) "YES" else "NO")

}