fun main() {
    val h1 = readln().toInt()
    val h2 = readln().toInt()
    val h3 = readln().toInt()

    when (h2) {
        in h3..h1, in h1..h3 -> println(true)
        else -> println(false)
    }
}