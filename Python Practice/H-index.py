#Hindex-leetcode
def index(cit):
  cit.sort()
  maximum=0
  n=len(cit)
  for i in range(n):
    if cit[i]>=n-i:
      maximum=max(maximum,n-i)
  return maximum

cit=list(map(int,input(" ").split(",")))
print("output",index(cit))

"""
Input: citations = [3,0,6,1,5]
Output: 3
For the given input citations = [3, 0, 6, 1, 5], 
the function calculates that the author has 3 papers with at least 3 citations each
which matches the definition of the H-Index. Therefore, the output is 3.

input:1,3,1
output:1

For i = 0 and i = 1, the condition is not satisfied because citations[0] and citations[1] are not greater than or equal to the number of papers remaining (3 and 2 respectively).
For i = 2, citations[2] = 3 is greater than or equal to 1 (3 papers, each cited at least once).

"""
