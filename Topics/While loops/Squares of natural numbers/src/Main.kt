fun main() {
    val n = readln().toInt()
    var iterator = 1
    while (iterator * iterator <= n) {
        println(iterator * iterator)
        iterator++
    }
}