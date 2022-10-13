fun main() {
    val n = readln().toInt()
    val sequence = MutableList(n) { readln().toInt() }
    val m = readln().toInt()

    println(if (m in sequence) "YES" else "NO")
}