Grid Solver finds the largest product of n consecutive numbers in an n x n matrix.

Note: the matrix has to be square.

The consecutive numbers can either be horizontal, vertical or diagonal (North East to South West, or North West to South East)

solve() returns the largest product found in the matrix along with its factors and indices, wrapped in a GridProduct record.

In case there are multiple consecutive entries that gives the same product, solve() returns a list of GridProducts


![How consecutive numbers are calculated](illustration.png)
