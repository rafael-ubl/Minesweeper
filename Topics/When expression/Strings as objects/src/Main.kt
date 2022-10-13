fun main() {
    val input = readLine()!!
    println(
        when {
            input.isNotEmpty() && input.first() == 'i' -> (input.drop(1).toInt() + 1).toString()
            input.isNotEmpty() && input.first() == 's' -> input.drop(1).reversed()
            else -> input
        }
    )
}