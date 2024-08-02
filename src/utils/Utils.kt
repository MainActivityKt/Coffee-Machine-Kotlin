package utils

object Utils {
    enum class Message(val message: String) {
        WATER_AMOUNT_MESSAGE("Write how many ml of water the coffee machine has:"),
        MILK_AMOUNT_MESSAGE("Write how many ml of milk the coffee machine has:"),
        COFFEE_AMOUNT_MESSAGE("Write how many grams of coffee beans the coffee machine has:"),
        NEEDED_COFFEE_MESSAGE("Write how many cups of coffee you will need:")
    }

    val lessServings = { possibleServings: Int -> "No, I can make only $possibleServings cups of coffee" }
    val sufficientServings = { extraServings: Int ->
        "Yes, I can make that amount of coffee" + if (extraServings > 0) " (and even $extraServings more than that)" else ""
    }
}