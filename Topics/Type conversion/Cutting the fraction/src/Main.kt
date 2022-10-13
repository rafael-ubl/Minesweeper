fun main() {
    val input = readln().toDouble()
    var output = ""
    loop@ for (n in input.toBigDecimal().toPlainString()) {
        if (n == '.') break@loop
        output += n
    }
    println(output.toLong())
}