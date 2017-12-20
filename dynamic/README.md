# Dynamic Programming Algorithms

## Knapsack Problem

Given a total capacity, W, and a set of n items, each with a value, v, and weight w.
The problem being solved is the 0/1 Knapsack Problem which restricts the number of copies of each item to 0 or 1.
The goal is to determine the optimal value (max value) that we can get from a subset, S, of the items subject to 
the constraint that the total weight of the items in the subset is less than or equal to the total capacity, W.

Example: W = 100

| item | v  | w  | v/w   |
| ---- | -- | -- | ----- |
| 1    | 52 | 51 | 52/51 |
| 2    | 50 | 50 | 1     |
| 3    | 50 | 50 | 1     |

A greedy approach would be to pick the 1st k items sorted by v/w. In this example, it picks item 1 first and puts it in the knapsack. It then halts because adding items 2 or 3 to the knapsack will exceed the knapsack's total capacity. The greedy algorithm thus consists of only item 1 with a value of 52. The dynamic programming algorithm proposed here will pick the optimal subset of items 2 and 3, which fills the entire knapsack with an optimal value of 100.

### Input 

Refer to input_knapsack.txt for sample input file consisting of a list of n items.
Each line has two integers that correspond to the value and weight of an item, respectively.
The value and weight corresponding to each item are assumed to be non-negative integers.

### Usage

An example of the usage is as follows. W is the total capacity of the knapsack. It is assumed to be a non-negative integer.
```
$ javac Knapsack.java
$ java Knapsack input_knapsack.txt W
```
The above run will generate an output.txt file with the optimal value. 
For the knapsack instance from input_knapsack.txt, here is a sample of optimal values that should be expected:

| W     | optimal value |
| ----- | ------------- |
|  0    | 0             |
|  1    | 5             |
|  2    | 5             |
|  3    | 5             |
|  4    | 9             |
|  5    | 9             |
| 10    | 14            |
| >= 36 | 34            |
