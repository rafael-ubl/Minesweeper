// complete this function, add default values
fun carPrice(old: Int = 5, kilometers: Int = 100_000, maximumSpeed: Int = 120, automatic: Boolean = false) {
    val initialPrice = 20_000
    var price = initialPrice

    for (year in 1..old) price -= 2000

    if (maximumSpeed > 120) for (speed in 121..maximumSpeed) price += 100
    if (maximumSpeed < 120) for (speed in maximumSpeed until 120) price -= 100

    price -= (kilometers / 10_000) * 200

    if (automatic) price += 1500

    println(price)
}