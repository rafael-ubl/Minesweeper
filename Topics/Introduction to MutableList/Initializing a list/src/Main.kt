fun main() {
    val numbers = MutableList(100) { 0 }
    numbers[0] = 1
    numbers[99] = 100
    numbers[9] = 10

    // do not touch the lines below 
    println(numbers.joinToString())
}