package coffeemachine

import utils.Utils.Message.*
import utils.Utils.lessServings
import utils.Utils.sufficientServings

class ServingsCalculator {
    private var amountOfWater = 0
    private var amountOfMilk = 0 // in ml
    private var coffeeBeans = 0 // in g

    fun initializeAvailableIngredients() {
        println(WATER_AMOUNT_MESSAGE.message)
        amountOfWater = readln().toInt()
        println(MILK_AMOUNT_MESSAGE.message)
        amountOfMilk = readln().toInt()
        println(COFFEE_AMOUNT_MESSAGE.message)
        coffeeBeans = readln().toInt()
    }

    fun estimateServings() {
        println(NEEDED_COFFEE_MESSAGE.message)
        val requiredServing = readln().toInt()
        val possibleServing = minOf(amountOfWater / 200, amountOfMilk / 50, coffeeBeans / 15)
        println(
            if (requiredServing > possibleServing) { lessServings(possibleServing) }
            else sufficientServings(possibleServing - requiredServing)
        )
    }
}
fun main() {
    val ingredientCalculator = ServingsCalculator()
    ingredientCalculator.initializeAvailableIngredients()
    ingredientCalculator.estimateServings()
}
