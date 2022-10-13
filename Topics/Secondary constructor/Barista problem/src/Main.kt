class EspressoMachine {
    var costPerServing: Float = 0f

    constructor(coffeeCapsulesCount: Int, totalCost: Float) {
        costPerServing = totalCost / coffeeCapsulesCount
    }

    constructor(coffeeBeansWeight: Float, totalCost: Float) {
        costPerServing = (totalCost / (coffeeBeansWeight / 10).toInt())
    }
}