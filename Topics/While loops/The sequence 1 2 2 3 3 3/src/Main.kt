fun main() {
    val n = readln().toInt()
    val sequence = mutableListOf<Int>()
    var output = ""
    var index = 1

    while (sequence.size < n) {
        repeat(index) {
            if (sequence.size < n) {
                sequence.add(index)
            }
        }
        index++
    }

    for (i in sequence) {
        output += "$i "
    }

    println(output.dropLast(1))
}