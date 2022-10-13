fun main() {
    val length = readln().toInt()
    val list = MutableList(length) { readln().toInt() }
    val shiftedList = MutableList(length) { 0 }

    for (n in 0..list.lastIndex) {
        if (n == list.lastIndex) {
            shiftedList[0] = list[n]
        } else {
            shiftedList[n + 1] = list[n]
        }
    }

    println(shiftedList.joinToString(" "))
}