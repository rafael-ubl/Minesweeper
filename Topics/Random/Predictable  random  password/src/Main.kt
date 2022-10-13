import kotlin.random.Random

const val CHAR_MIN = 33
const val CHAR_MAX = 126
const val PASSWORD_LENGTH = 10

fun generatePredictablePassword(seed: Int): String {
    var randomPassword = ""
    val generator = Random(seed)
    repeat(PASSWORD_LENGTH) {
        randomPassword += generator.nextInt(CHAR_MIN, CHAR_MAX + 1).toChar()
    }
    return randomPassword
}