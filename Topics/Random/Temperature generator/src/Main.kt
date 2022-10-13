import kotlin.random.Random

const val MIN_TEMPERATURE = 20
const val MAX_TEMPERATURE = 30

fun generateTemperature(seed: Int): String {
    val generator = Random(seed)
    val length = 7
    val temperatures = MutableList(length) { generator.nextInt(MIN_TEMPERATURE, MAX_TEMPERATURE + 1) }

    return temperatures.joinToString(" ")
}