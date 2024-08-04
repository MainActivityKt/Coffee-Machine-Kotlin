package coffeemachine

import utils.Utils.Message.*

data class Coffee(val type: CoffeeType, val cost: Int, val requiredIngredients: Ingredient)

data class Ingredient(var water: Int, var milk: Int, var coffeeBeans: Int, var cups: Int = 1)

enum class Action { BUY, FILL, TAKE }

enum class CoffeeType { ESPRESSO, LATTE, CAPPUCCINO }

class CoffeeMachine {
    private val availableIngredients = Ingredient(400, 540, 120, 9  )
    private var moneyLeft = 550  // In USD
    private val availableCoffees = listOf(
        Coffee(CoffeeType.ESPRESSO, 4, Ingredient(250, 0, 16)),
        Coffee(CoffeeType.LATTE, 7, Ingredient(350, 75, 20)),
        Coffee(CoffeeType.CAPPUCCINO, 6, Ingredient(200, 100, 12))
    )

    fun startMachine() {
        printState()
        getAction()
        printState()
    }

    private fun printState() {
        println("The coffee machine has:")
        availableIngredients.apply {
            println("$water ml of water")
            println("$milk ml of milk")
            println("$coffeeBeans g of coffee beans")
            println("$cups disposable cups")
            println("$$moneyLeft of money")
            println()
        }
    }

    private fun getAction() {
        println(WRITE_ACTION_MESSAGE.message)
        val input = readln()
        when {
            input.equals(Action.BUY.name, true) -> buyCoffee()
            input.equals(Action.FILL.name, true) -> fillMachine()
            input.equals(Action.TAKE.name, true) -> depositMoney()
        }
    }

    private fun buyCoffee() {
        println(BUY_COFFEE_MENU.message)
        val input = readln().toInt()
        val chosenCoffee = availableCoffees[input - 1]
        availableIngredients.apply {
            coffeeBeans -= chosenCoffee.requiredIngredients.coffeeBeans
            milk -= chosenCoffee.requiredIngredients.milk
            water -= chosenCoffee.requiredIngredients.water
            cups -= chosenCoffee.requiredIngredients.cups
            moneyLeft += chosenCoffee.cost
        }
    }

    private fun fillMachine() {
        println(FILL_MESSAGE_WATER.message)
        val addedWater = readln().toInt()
        println(FILL_MESSAGE_MILK.message)
        val addedMilk = readln().toInt()
        println(FILL_MESSAGE_COFFEE_BEANS.message)
        val addedBeans = readln().toInt()
        println(FILL_MESSAGE_CUPS.message)
        val addedCups = readln().toInt()
        availableIngredients.apply {
            water += addedWater
            milk += addedMilk
            coffeeBeans += addedBeans
            cups += addedCups
        }
        println()
    }

    private fun depositMoney() {
        println("I gave you $$moneyLeft\n")
        moneyLeft = 0
    }
}

fun main() {
    CoffeeMachine().startMachine()
}