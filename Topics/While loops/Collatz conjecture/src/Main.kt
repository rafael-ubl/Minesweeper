fun main() {
    var n = readln().toInt()
    var sequence = "$n"

    while (n != 1) {
        n = if (n % 2 == 0) n / 2 else n * 3 + 1
        sequence += " $n"
    }

    println(sequence)
}