package coffeemachine

class IngredientCalculator() {
    private val cupsOfCoffee: Int
    private val amountOfWater: Int // in ml
    private val amountOfMilk: Int // in ml
    private val coffeeBeans: Int // in g

    init {
        println("Write how many cups of coffee you will need:")
        cupsOfCoffee = readln().toInt()
        amountOfWater = cupsOfCoffee * 200
        amountOfMilk = cupsOfCoffee * 50
        coffeeBeans = cupsOfCoffee * 15
    }

    fun printRequirements() {
        println("For $cupsOfCoffee cups of coffee you will need:")
        println("$amountOfWater ml of water")
        println("$amountOfMilk ml of milk")
        println("$coffeeBeans g of coffee beans")
    }

}
fun main() {
    val ingredientCalculator = IngredientCalculator()
    ingredientCalculator.printRequirements()
}