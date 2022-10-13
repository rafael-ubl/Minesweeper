fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()

    println(
        if (a + b <= c || a + c <= b || b + c <= a) {
            "NO"
        } else {
            "YES"
        }
    )
}