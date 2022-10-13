class Car(val make: String, val year: Int) {

    var speed: Int = 0

    fun accelerate() {
        speed += 5
    }

    fun decelerate() {
        if (speed - 5 < 0) {
            speed = 0
        } else {
            speed -= 5
        }
    }
}