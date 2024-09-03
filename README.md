# Coffee Machine

This project simulates a coffee machine.

The machine works with typical products: coffee, milk, sugar, and plastic cups;
if it runs out of something, it shows a notification.

One can get three types of coffee:
espresso, cappuccino, and latte. Since nothing’s for free, it also collects the money.

## Stage 1/6: Making coffee
In this stage, a number of texts is printed out to the console.

Stage implementation: [SimpleCoffeeMachine.kt](src/coffeemachine/SimpleCoffeeMachine.kt)


**Example:**

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

**Example:**

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

**Example 1:**

    Write how many ml of water the coffee machine has:
    > 1550
    Write how many ml of milk the coffee machine has:
    > 299
    Write how many grams of coffee beans the coffee machine has:
    > 300
    Write how many cups of coffee you will need:
    > 3
    Yes, I can make that amount of coffee (and even 2 more than that)

**Example 2:**

    Write how many ml of water the coffee machine has:
    > 500
    Write how many ml of milk the coffee machine has:
    > 250
    Write how many grams of coffee beans the coffee machine has:
    > 200
    Write how many cups of coffee you will need:
    > 10
    No, I can make only 2 cups of coffee

**Example 3:**

    Write how many ml of water the coffee machine has:
    > 300
    Write how many ml of milk the coffee machine has:
    > 65
    Write how many grams of coffee beans the coffee machine has:
    > 100
    Write how many cups of coffee you will need:
    > 1
    Yes, I can make that amount of coffee

## Stage 4/6: Buy, fill, take!

In this stage, the program is extended and now can perform either of three tasks, buying a coffee, filling the machine, and depositing money. 

On each task's completion, it outputs the amount of current ingredients and left money, and exits.

Stage implementation: [CoffeeMachine.kt](src/coffeemachine/CoffeeMachine.kt)

**Example 1:**

    The coffee machine has:
    400 ml of water
    540 ml of milk
    120 g of coffee beans
    9 disposable cups
    $550 of money
    
    Write action (buy, fill, take):
    > fill
    Write how many ml of water you want to add:
    > 2000
    Write how many ml of milk you want to add:
    > 500
    Write how many grams of coffee beans you want to add:
    > 100
    Write how many disposable cups you want to add:
    > 10
    
    The coffee machine has:
    2400 ml of water
    1040 ml of milk
    220 g of coffee beans
    19 disposable cups
    $550 of money


**Example 2:**

    The coffee machine has:
    400 ml of water
    540 ml of milk
    120 g of coffee beans
    9 disposable cups
    $550 of money
    
    Write action (buy, fill, take):
    > take
    I gave you $550
    
    The coffee machine has:
    400 ml of water
    540 ml of milk
    120 g of coffee beans
    9 disposable cups
    $0 of money

## Stage 5/6: Keep track of the supplies  + Stage 6/6:Brush up your code

Continuing to expand the coffee machine's functionalities, now our coffee machine works endlessly and supports even more tasks.

The customer can now choose to `buy`, `fill`, `take`, `remaining`, and `exit`.

`buy`: The action of buying coffee displays a menu of available coffee drinks the customer can choose, each one having their own price and required ingredients.

- For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
- For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
- And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.

The customer can revert their action of buying a coffee, by choosing `back` option, in case they change their mind.  

`fill`: Filling up the coffee machine with provided amount of ingredients (water, milk, coffee beans, and disposable cups).

`take`: Deposits the available money

`remaining`: Displays available ingredients and money in the coffee machine.

`exit`: Terminates the program
Remaining, displays the amount of available ingredients and money in the machine. 

`In stage 6`, the program's functionality is not changed, rather the code is refactored, a new method to represent all actions the machine can do is added, based on its current state.

Stage implementation: [SimultaneousCoffeeMachine.kt](src/coffeemachine/SimultaneousCoffeeMachine.kt)

Note: The above implementation matches for both stages 5 and 6. 

**Example:**

    Write action (buy, fill, take, remaining, exit):
    > remaining
    
    The coffee machine has:
    400 ml of water
    540 ml of milk
    120 g of coffee beans
    9 disposable cups
    $550 of money
    
    Write action (buy, fill, take, remaining, exit):
    > buy
    
    What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
    > 2
    I have enough resources, making you a coffee!
    
    Write action (buy, fill, take, remaining, exit):
    > remaining
    
    The coffee machine has:
    50 ml of water
    465 ml of milk
    100 g of coffee beans
    8 disposable cups
    $557 of money
    
    Write action (buy, fill, take, remaining, exit):
    > buy
    
    What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
    > 2
    Sorry, not enough water!
    
    Write action (buy, fill, take, remaining, exit):
    > fill
    
    Write how many ml of water you want to add:
    > 1000
    Write how many ml of milk you want to add:
    > 0
    Write how many grams of coffee beans you want to add:
    > 0
    Write how many disposable cups you want to add:
    > 0
    
    Write action (buy, fill, take, remaining, exit):
    > remaining
    
    The coffee machine has:
    1050 ml of water
    465 ml of milk
    100 g of coffee beans
    8 disposable cups
    $557 of money
    
    Write action (buy, fill, take, remaining, exit):
    > buy
    
    What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
    > 2
    I have enough resources, making you a coffee!
    
    Write action (buy, fill, take, remaining, exit):
    > remaining
    
    The coffee machine has:
    700 ml of water
    390 ml of milk
    80 g of coffee beans
    7 disposable cups
    $564 of money
    
    Write action (buy, fill, take, remaining, exit):
    > take
    
    I gave you $564
    
    Write action (buy, fill, take, remaining, exit):
    > remaining
    
    The coffee machine has:
    700 ml of water
    390 ml of milk
    80 g of coffee beans
    7 disposable cups
    $0 of money
    
    Write action (buy, fill, take, remaining, exit):
    > exit

