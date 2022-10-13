fun main() {
    val length = readln().toInt()
    val list = MutableList(length) { readln().toInt() }

    for (i in 0 until list.size) {
        if (list[i] == list.maxOrNull()) {
            println(i)
            return
        }
    }
}