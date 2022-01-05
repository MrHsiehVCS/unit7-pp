# Unit 7 Programming Project

In this project, you are going to work with arrays, `List`s and `ArrayList`s. You are also going to work on class creation and interaction.

You may use the `Main` class for testing purposes, but all of your code for the project should be in the classes described below.

You may create as many helper classes and methods as you deem necessary, but you must include the methods described below, and make use of the `Deck` and `Card` classes provided (unaltered) in order to recieve full credit.

## Part A - `Sorts.java`

In class, we discussed the algorithms behind two different types of sorts: **selection sort** and **insertion sort**. Create a static class `Sorts` that has the following static methods:

* `int[] selectionSort(int[] x)`: Returns the array x sorted in **ascending** order using a selection sort
* `int[] insertionSort(int[] x)`: Returns the array x sorted in **ascending** order using an insertion sort
* `List<Integer> selectionSort(List<Integer> x)`: Returns the `ArrayList` x sorted in **descending** order using a selection sort
* `List<Integer> insertionSort(List<Integer> x)`: Returns the `ArrayList` x sorted in **descending** order using an insertion sort

Because all the methods in this class are static, remember to not have any instance variables or constructors. Do not modify the parameters in any way.

## Part B - `War.java`

Create a class called `War` that plays the game `War`. The rules of `War` are as follows:

- There are two `Player`s in the game.
- Each `Player`'s name is requested and stored.
- A `Deck` of `Card`s is evenly dealt to all `Player`s.
- Until one `Player` has all the `Card`s
    1. Each `Player` flips over the "top" card in it's hand.
    2. The `Player` with the highest `Card` gets all of the `Card`s added to their hand. The loser has their `Card`s removed from their hand.
    3. If both `Player`s have the same value `Card`, they commit to **War**
    4. In **War**, each `Player` deals three `Card`s face-down, then one `Card` face-up.
    The `Player` with the highest `Card` gets all of the `Card`s from Steps 2 - 4 added to it's hand.
    In the case of a tie, each player gets their cards back.
    5. Ask each `Player` if they wants to keep playing. If yes, it keeps the `Card`s in his/her hand. Otherwise, the other `Player` wins and the game is over.
- Display the name of the Winner.

You must use at least two `ArrayList`s in your program.

Make sure that the program clearly communicates to the user(s) what is happening at each step. 

The following lines of code ran from another class (like `Main.java`) must start a game of `War`.

    War game = new War();
    game.play();

## GRADING BREAKDOWN

- Properly JavaDoc'ed all code wrote: 20 points
- Attempted PART A: 20 points
- PART A works as expected: 20 points
- Attempted PART B: 20 points
- Manual testing of War game: 20 points

Submit by pushing to your git repo. (add, commit, then push)

## **BONUS - Expanded War**

If you finish early, show your real mastery of the material by implementing a version of War that can work for n-Players (any number of players, minimum 2).
