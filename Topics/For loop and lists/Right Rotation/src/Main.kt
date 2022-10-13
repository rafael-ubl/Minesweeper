fun main() {
    val length = readln().toInt()
    val list = MutableList(length) { readln().toInt() }
    val step = readln().toInt() % length
    val shiftedList = MutableList(length) { 0 }

    for (n in 0..list.lastIndex) {
        if (n <= list.lastIndex - step) {
            shiftedList[n + step] = list[n]
        } else {
            if (n + step - length < list.size && n < list.size) {
                shiftedList[n + step - length] = list[n]
            }
        }
    }

    println(shiftedList.joinToString(" "))
}