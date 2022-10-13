fun main() {
    val a = readln().toInt()
    val b = readln().toInt()

    var result = 1L

    for (number in a until b) {
        result *= number
    }

    println(result)
}