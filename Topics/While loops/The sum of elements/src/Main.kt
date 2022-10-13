fun main() {
    val sequence = mutableListOf<Int>()
    var element: Int
    do {
        element = readln().toInt().takeUnless {  }
        sequence.add(element)
    } while (element != 0)
    println(sequence.sum())
}