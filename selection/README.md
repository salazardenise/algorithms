Implementation
--------------
Implementations of the following selection algorithms are included thus far.
Selection refers to the kth order statistic, or kth smallest number.

- randomSelect
- heapSelect

Input
--------------
Refer to input.txt for sample input file consisting of a list of integers.
The input file consists of n number of integers.

Usage
--------------
An example of the usage of one of the implementations is as follows.
k is an integer indicating the order statistic desired. k must be within 1 and n inclusive.

```
$ javac randomSelect.java
$ java randomSelect input.txt k
```

The above run will generate an output.txt file with the kth order statistic.
