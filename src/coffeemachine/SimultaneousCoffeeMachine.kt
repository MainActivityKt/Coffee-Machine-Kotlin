package coffeemachine

import utils.Utils.Message.*
import utils.Utils.Coffee
import utils.Utils.CoffeeType
import utils.Utils.Action
import utils.Utils.Ingredient
import utils.Utils.notEnoughResources
import utils.Utils.MachineState.*

class SimultaneousCoffeeMachine {
    private var currentState = CHOOSING_ACTION
    private val availableIngredients = Ingredient(400, 540, 120, 9)
    private var moneyLeft = 550  // In USD
    private val availableCoffees = listOf(
        Coffee(CoffeeType.ESPRESSO, 4, Ingredient(250, 0, 16)),
        Coffee(CoffeeType.LATTE, 7, Ingredient(350, 75, 20)),
        Coffee(CoffeeType.CAPPUCCINO, 6, Ingredient(200, 100, 12))
    )

    fun startMachine() {
        var input = getInput() as String
        println()
        while (!input.equals(Action.EXIT.name, true)) {
            when {
                input.equals(Action.BUY.name, true) -> buyCoffee()
                input.equals(Action.FILL.name, true) -> fillMachine()
                input.equals(Action.TAKE.name, true) -> depositMoney()
                input.equals(Action.REMAINING.name, true) -> printState()
            }
            println()
            currentState = CHOOSING_ACTION
            input = getInput() as String
            println()
        }
    }

    private fun getInput(): Any {
        when(currentState) {
            CHOOSING_ACTION -> {
                println(WRITE_ACTION_EXTENDED_MESSAGE.message)
                return readln()
            }
            TAKING_ORDER -> {
                println(MENU_EXTENDED.message)
                readln().apply {
                    return if (equals("back", true)) -1 else toInt()
                }
            }
            BEING_FILLED -> {
                Ingredient(0, 0, 0, 0).apply {
                    println(FILL_MESSAGE_WATER.message)
                    water = readln().toInt()
                    println(FILL_MESSAGE_MILK.message)
                    milk = readln().toInt()
                    println(FILL_MESSAGE_COFFEE_BEANS.message)
                    coffeeBeans = readln().toInt()
                    println(FILL_MESSAGE_CUPS.message)
                    cups = readln().toInt()
                    return this
                }
            }

        }
    }

    private fun printState() {
        println("The coffee machine has:")
        availableIngredients.apply {
            println("$water ml of water")
            println("$milk ml of milk")
            println("$coffeeBeans g of coffee beans")
            println("$cups disposable cups")
            println("$$moneyLeft of money")
        }
    }

    private fun buyCoffee() {
        currentState = TAKING_ORDER
        val input = getInput()
        if (input == -1) return
        val chosenCoffee = availableCoffees[(input as Int) - 1]
        val insufficientResource = getInsufficientResource(chosenCoffee)
        if (insufficientResource.isNullOrEmpty()) {
            availableIngredients.apply {
                coffeeBeans -= chosenCoffee.requiredIngredients.coffeeBeans
                milk -= chosenCoffee.requiredIngredients.milk
                water -= chosenCoffee.requiredIngredients.water
                cups -= chosenCoffee.requiredIngredients.cups
                moneyLeft += chosenCoffee.cost
            }
            println(COFFEE_BEING_MADE.message)
        } else {
            println(notEnoughResources(insufficientResource))
        }
    }

    private fun getInsufficientResource(coffee: Coffee): String? {
        coffee.requiredIngredients.apply {
            return(if (water > availableIngredients.water) ("water")
            else if (coffeeBeans > availableIngredients.coffeeBeans) ("coffee beans")
            else if (milk > availableIngredients.milk) "milk"
            else if (cups > availableIngredients.cups) "cups"
            else null)
        }
    }

    private fun fillMachine() {
        currentState = BEING_FILLED
        val addedIngredients = getInput() as Ingredient
        availableIngredients.apply {
            water += addedIngredients.water
            milk += addedIngredients.milk
            coffeeBeans += addedIngredients.coffeeBeans
            cups += addedIngredients.cups
        }
    }

    private fun depositMoney() {
        println("I gave you $$moneyLeft")
        moneyLeft = 0
    }
}

fun main() {
    SimultaneousCoffeeMachine().startMachine()
}