fun main() {
    val personInfo = readln()
    val splitInfo = personInfo.split(" ")
    val firstName = splitInfo[0]
    val familyName = splitInfo[1]
    val age = splitInfo[2]

    println("${firstName[0]}. $familyName, $age years old")
}