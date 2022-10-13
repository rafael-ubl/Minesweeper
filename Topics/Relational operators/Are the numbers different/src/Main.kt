fun main() {
    val n1 = readln().toInt()
    val n2 = readln().toInt()
    val n3 = readln().toInt()

    if (n1 == n2 || n1 == n3 || n2 == n3) {
        println(false)
    } else {
        println(true)
    }
}