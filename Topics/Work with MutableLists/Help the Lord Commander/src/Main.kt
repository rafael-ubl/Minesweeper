fun main() {
    val beyondTheWall = readLine()!!.split(", ").map { it }.toMutableList()
    val backToTheWall = readLine()!!.split(", ").map { it }.toMutableList()
    // do not touch the lines above
    println(beyondTheWall.size <= backToTheWall.size)
}