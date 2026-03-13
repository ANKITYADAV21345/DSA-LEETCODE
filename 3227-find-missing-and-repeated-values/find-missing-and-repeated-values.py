# apna college article
from typing import List


class Solution(object):
   def findMissingAndRepeatedValues(self, grid):
       """
       :type grid: List[List[int]]
       :rtype: List[int]
       """
       n = len(grid)
       n2 = n * n
       freq = [0] * (n2 + 1)  # Frequency array to track occurrences
     # Initialise repeated and missing with -1


       repeated = -1
       missing = -1


       # Count occurrences of each number in the grid
       for i in range(n):
           for j in range(n):
               freq[grid[i][j]] += 1


       # Find the repeated and missing numbers
       for i in range(1, n2 + 1):
           if freq[i] == 2:
               repeated = i
           elif freq[i] == 0:
               missing = i


       return [repeated, missing]






