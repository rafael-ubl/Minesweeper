enum class DangerLevel(val danger: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel(): Int = when (this.name) {
        "HIGH" -> 3
        "MEDIUM" -> 2
        else -> 1
    }
}

