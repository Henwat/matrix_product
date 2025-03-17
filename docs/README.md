The **GridAnalyzer** package contains classes to parse and find the largest product of k consecutive numbers in a square matrix.

- **GridParser** parse a .txt-file containing an n x n matrix. 
- The static method *parse()* takes a Path-argument locating file containing the matrix.

- *GridProduct* stores a product calculated from a matrix along with its factors and indices of the factors.

- *GridSolver* finds the largest product of n consecutive numbers in an n x n matrix.
- The static method *solve()* takes an int[][] *grid*, and an int *kConsecutive* of the number of consecutive numbers,  as input.   
- The consecutive numbers can either be horizontal, vertical or diagonal (North East to South West, or North West to South East) - see illustration below.
- In case there are multiple consecutive entries that gives the same product, .solve() returns a list of GridProducts.

![How consecutive numbers are calculated](illustration.png)
