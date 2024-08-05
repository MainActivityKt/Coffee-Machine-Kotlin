package utils

object Utils {


    data class Coffee(val type: CoffeeType, val cost: Int, val requiredIngredients: Ingredient)

    data class Ingredient(var water: Int, var milk: Int, var coffeeBeans: Int, var cups: Int = 1)

    enum class Action { BUY, FILL, TAKE, REMAINING, EXIT }

    enum class CoffeeType { ESPRESSO, LATTE, CAPPUCCINO }

    enum class MachineState{
        CHOOSING_ACTION, TAKING_ORDER, BEING_FILLED
    }
    enum class Message(val message: String) {
        WATER_AMOUNT_MESSAGE("Write how many ml of water the coffee machine has:"),
        MILK_AMOUNT_MESSAGE("Write how many ml of milk the coffee machine has:"),
        COFFEE_AMOUNT_MESSAGE("Write how many grams of coffee beans the coffee machine has:"),
        NEEDED_COFFEE_MESSAGE("Write how many cups of coffee you will need:"),

        //stage 3
        WRITE_ACTION_MESSAGE("Write action (buy, fill, take): "),
        MENU("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: "),
        FILL_MESSAGE_WATER("Write how many ml of water you want to add: "),
        FILL_MESSAGE_MILK("Write how many ml of milk you want to add: "),
        FILL_MESSAGE_COFFEE_BEANS("Write how many grams of coffee beans you want to add: "),
        FILL_MESSAGE_CUPS("Write how many disposable cups you want to add: "),

        //stage 4
        WRITE_ACTION_EXTENDED_MESSAGE("Write action (buy, fill, take, remaining, exit): "),
        MENU_EXTENDED("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: "),
        COFFEE_BEING_MADE("I have enough resources, making you a coffee!")
    }

    val lessServings = { possibleServings: Int -> "No, I can make only $possibleServings cups of coffee" }
    val sufficientServings = { extraServings: Int ->
        "Yes, I can make that amount of coffee" + if (extraServings > 0) " (and even $extraServings more than that)" else ""
    }

    val notEnoughResources = { ingredient: String -> "Sorry, not enough $ingredient!" }

}

