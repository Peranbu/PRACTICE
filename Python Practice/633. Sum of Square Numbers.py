from math import sqrt
def Square(c):
  for a in range(int(sqrt(c))+1):
    b=sqrt(c-a*a)
    if b==int(b):
      return True
  return False

c=int(input(" "))
print("output",Square(c))

"""
Example 1:
Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:
Input: c = 3
Output: false

"""

 
