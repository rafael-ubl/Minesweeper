fun main() {
    val word = readln()
    val n = readln().toInt()

    println("Symbol # $n of the string \"$word\" is '${word[n - 1]}'")
}