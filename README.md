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

Stage implementation: [IngredientsCalculator.kt](src/coffeemachine/IngredientsCalculator.kt)

Example:

    Write how many cups of coffee you will need:
    > 125
    For 125 cups of coffee you will need:
    25000 ml of water
    6250 ml of milk
    1875 g of coffee beans

## Stage 3/6: Estimate the number of servings

A real coffee machine doesn't have an infinite supply of water, milk, or coffee beans.
And if one inputs a huge number, it's almost certain that
a real coffee machine wouldn't have the supplies needed to make all that coffee for them.

In this stage, the program will check 
amounts of water, milk, and coffee beans available in the coffee machine at the moment.

Stage implementation: [ServingsCalculator.kt](src/coffeemachine/ServingsCalculator.kt)

Example 1:



    Write how many ml of water the coffee machine has:
    > 1550
    Write how many ml of milk the coffee machine has:
    > 299
    Write how many grams of coffee beans the coffee machine has:
    > 300
    Write how many cups of coffee you will need:
    > 3
    Yes, I can make that amount of coffee (and even 2 more than that)

Example 2:

    Write how many ml of water the coffee machine has:
    > 500
    Write how many ml of milk the coffee machine has:
    > 250
    Write how many grams of coffee beans the coffee machine has:
    > 200
    Write how many cups of coffee you will need:
    > 10
    No, I can make only 2 cups of coffee

Example 3:

    Write how many ml of water the coffee machine has:
    > 300
    Write how many ml of milk the coffee machine has:
    > 65
    Write how many grams of coffee beans the coffee machine has:
    > 100
    Write how many cups of coffee you will need:
    > 1
    Yes, I can make that amount of coffee