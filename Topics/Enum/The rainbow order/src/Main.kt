fun main() {
    val color = readLine()!!
    // put your code here
    println(Rainbow.valueOf(color.uppercase()).ordinal + 1)
}

enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}