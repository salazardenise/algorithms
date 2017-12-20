# Dynamic Programming Algorithms

## Knapsack Problem

Given are a set of n items.
The value and weight corresponding to each item are assumed to be nonnegative integers.
Also given is a total capacity, W, of the knapsack, which is also assumed to be a nonnegative integer.
The goal is to determine the optimal value (max value) that we can get from a subset, S, of the items subject to 
the constraint that the total weight of the items in the subset is less than or equal to the total capacity, W.

### Input 

Refer to input_knapsack.txt for sample input file consisting of a list of n items.
Each line has two integers that correspond to the value and weight of an item, respectively.

### Usage

An example of the usage is as follows. W is the total capacity of the knapsack.
```
$ javac Knapsack.java
$ java Knapsack input_knapsack.txt W
```
The above run will generate an output.txt file with the optimal value. 
For the knapsack instance from input_knapsack.txt, the following optimal values should be expected:

| W   | optimal value |
| --- | ------------- |
|  0  | 0             |
|  1  | 5             |
|  2  | 5             |
|  3  | 5             |
|  4  | 9             |
|  5  | 9             |
| 10  | 14            |
| 100 | 34            |
