# Coffee Machine

This project simulates a coffee machine.

The machine works with typical products: coffee, milk, sugar, and plastic cups;
if it runs out of something, it shows a notification.

One can get three types of coffee:
espresso, cappuccino, and latte. Since nothing’s for free, it also collects the money.

## Stage 1/6: Making coffee
In this stage, a number of texts is printed out to the console.

Stage implementation: [SimpleCoffeeMachine.kt](src/coffeemachine/SimpleCoffeeMachine.kt)


Example

    Starting to make a coffee
    Grinding coffee beans
    Boiling water
    Mixing boiled water with crushed coffee beans
    Pouring coffee into the cup
    Pouring some milk into the cup
    Coffee is ready!

## Stage 2/6: Ingredient calculator
In this stage:
- The numbers of needed coffee drinks is read from the input.
- The program figures out how much of each ingredient the machine will need.

    One cup of coffee made on this coffee machine contains `200` ml of
    water, `50` ml of milk, and `15` g of coffee beans.
- The required ingredient amounts is printed to the user.

Stage Implementation: [IngredientsCalculator.kt](src/coffeemachine/IngredientsCalculator.kt)

Example:

    Write how many cups of coffee you will need:
    > 125
    For 125 cups of coffee you will need:
    25000 ml of water
    6250 ml of milk
    1875 g of coffee beans

