import kotlin.random.Random

fun createDiceGameRandomizer(n: Int): Int {
    var seed = 0
    val friendSum = MutableList(n) { 0 }
    val mySum = MutableList(n) { 0 }

    do {
        seed++
        val randomGenerator = Random(seed)
        for (i in 0 until n) {
            friendSum[i] = randomGenerator.nextInt(1, 7)
        }
        for (i in n until n + n) {
            mySum[i - n] = randomGenerator.nextInt(1, 7)
        }
    } while (friendSum.sum() > mySum.sum())

    return seed
}