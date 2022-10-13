fun main() {
    val n1 = readln().toInt()
    val n2 = readln().toInt()
    val n3 = readln().toInt()

    when {
        n1 > 0 && n2 <= 0 && n3 <= 0 -> println(true)
        n1 <= 0 && n2 > 0 && n3 <= 0 -> println(true)
        n1 <= 0 && n2 <= 0 && n3 > 0 -> println(true)
        else -> println(false)
    }
}