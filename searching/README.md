Implementation 
-------------
Implementations of the following searching algorithms are included thus far:

- BinarySearch

Input
-------------
Refer to input.txt for sample input file consisting of a list of integers. 
The input file consists of n number of integers. 
Note: The list must be in ascending order.

Usage
-------------
An example of the usage of one of the implementations is as follows. k is the key that is being searched for.
Note: k must be an integer.
```
$ javac BinarySearch.java
$ java BinarySearch input.txt k
```
The above run will generate an output.txt file with the lower bound and upper bound index values of the key k on separate lines.
These index values are 0-based.

- If the input does not contain k, the lower and upper bound will be -1.
- If the input searches for a k that is unique, the lower an upper bound will be the same index.
- If the input searches for a k that is repeated, the lower and upper bound indicate that k is found at this range of indices of the list. 
