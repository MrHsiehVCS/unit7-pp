# Unit 7 Programming Project

In this project, you are going to work with arrays, `List`s and `ArrayList`s. You are also going to work on class creation and interaction.

You may use the `Main` class for testing purposes, but all of your code for the project should be in the classes described below.

You may create as many helper classes and methods as you deem necessary, but you must include the methods described below, and make use of the `Deck` and `Card` classes provided (unaltered) in order to recieve full credit.

## Part A - 'Search.java'

Write one version of binary search, with the following method signature:
* `public static int binarySearch(int[] arr, int targetNumber)`

`targetNumber` is the value we are searching for. If the value is in the array/list, the function should return the index of the value. Otherwise, it returns -1.

If you need a refresher on how binary search works, you can google it. 

Precondition: the given array is sorted, and there are no repeats (although binary search still works fine with repeats, it's just easier for testing)

## Part B - `Sort.java`

In class, we discussed the algorithms behind two different types of sorts: **selection sort** and **insertion sort**. Create a static class `Sorts` that has the following `static` methods:

* `int[] selectionSort(int[] x)`: Returns the array x sorted in **ascending** order using a selection sort
* `int[] insertionSort(int[] x)`: Returns the array x sorted in **ascending** order using an insertion sort
* `List<Integer> selectionSort(List<Integer> x)`: Returns the `ArrayList` x sorted in **descending** order using a selection sort
* `List<Integer> insertionSort(List<Integer> x)`: Returns the `ArrayList` x sorted in **descending** order using an insertion sort

Because all the methods in this class are `static`, remember to not have any instance variables or constructors. Do not modify the parameters in any way.

## Part C - `War.java`

Create a class called `War` that plays the classic card game `War`. The rules of `War` are as follows:

- There is 1 user player in the game, and 1 computer player.
- A `Deck` of `Card`s is evenly dealt to both `Player`s.
- Until one `Player` has all the `Card`s
    1. Each `Player` flips over the "top" card in it's hand.
    2. The `Player` with the highest `Card` gets all of the `Card`s added to the bottom of their hand. The loser has their `Card`s removed from their hand.
    3. If both `Player`s have the same value `Card`, they commit to **War**
    4. In **War**, each `Player` deals three `Card`s face-down, then one `Card` face-up.
    The `Player` with the highest `Card` gets all of the `Card`s from Steps 2 - 4 added to it's hand.
    In the case of a tie, repeat another **War**, the winner getting 4 more cards
    5. Ask each `Player` if they wants to keep playing. If yes, it keeps the `Card`s in his/her hand. Otherwise, the other `Player` wins and the game is over.
- Display the name of the Winner.

You must use at least two `ArrayList`s in your program, one for each user's personal deck of cards.

Make sure that the program clearly communicates to the user(s) what is happening at each step. 

The following lines of code ran from another class (like `Main.java`) must start a game of `War`.

```
War game = new War();
game.play();
```

Your `War` class must include the following: 
- A parameterless constructor that sets the game up as intended in the rules
- A parameterized constructor that takes in 2 `ArrayList<Card>` which represent the human player's and the computer's decks, respectively
- A getter for the player's deck, and one for the computer's deck
- A `playTurn` method that processes one turn of the game (there may be multiple wars in 1 turn)
- A method that returns true if the game is over, and false otherwise
- A `play` function that runs the full version of the game (this will be tested manually)

The exact naming for each of these functions can be found in `WarTests.java`


## Grading Breakdown

- Code compiles & runs without errors: 1 pts
- Formatting/indentation: 2 points
- All code commented: 2 points
- No public methods/attributes besides the ones specified (additional private methods/attributes are encouraged): 1 point
- All code is DRY (Don't repeat yourself): 3 points
- Part A (Search) Test Cases: 6 points (0.5 pts each)
- Part B (Sort) Test Cases: 8 points (0.5 pts each)
- Automated Testing of `War` class: 5 points (0.5 pts each)
- Manual Testing of the `War` user experience (2 pts)

Total: 30 points

## Submitting

Submit by pushing to your git repo. (add, commit, then push)

## **EXTRA CREDIT - Expanded War**

For extra credit, you can implement a version of War that can work for n-Players (any number of players, minimum 2).
