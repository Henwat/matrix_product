## GridAnalyzer 

The **GridAnalyzer** package contains classes to parse and find the largest product of k consecutive numbers in a square matrix.
  
- *GridParser* class parse a .txt-file containing an n x n matrix. 
  - The static method *parse()* takes a Path-argument locating the file containing the matrix.
  
- *GridProduct* is a record that stores a product calculated from a matrix along with its factors and indices of the factors.
  
- *GridSolver* finds the largest product of *k* consecutive numbers in an *n* x *n* matrix. Results are returned as a list of GridProducts.
  - The static method *solve()* takes an int[][] *grid*, and an int *kConsecutive* of the number of consecutive numbers,  as input.   
  - The consecutive numbers can either be horizontal, vertical or diagonal (North East to South West, or North West to South East) - see illustration below.


<img src="illustration.png" alt="How consecutive numbers are calculated" width="300" height="250" />
