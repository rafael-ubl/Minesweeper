fun main() {
    val amountOfInputs = readln().toInt()

    val inputArray = mutableListOf<Int>()

    for (i in 1..amountOfInputs) {
        inputArray.add(readln().toInt())
    }

    var sequenceLength = 0
    var maxSequenceLength = 0

//    for (number in 0 until inputArray.size - 1) {
//        if (inputArray[number] <= inputArray[number + 1]) {
//            sequenceLength++
//        } else {
//            if (sequenceLength >= maxSequenceLength) {
//                maxSequenceLength = sequenceLength
//            }
//            sequenceLength = 0
//        }
//    }

    for (number in 0 until inputArray.size - 1) {
        sequenceLength++
        if (inputArray[number] > inputArray[number + 1] && sequenceLength >= maxSequenceLength) {
            maxSequenceLength = sequenceLength
            sequenceLength = 0
        }
    }

    println(maxSequenceLength)
}