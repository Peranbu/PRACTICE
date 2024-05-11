def Climb(n):
  if n==1:
    return 1
  if n==2:
    return 2
  dp=[0]*(n+1)  #initialize n value with 0 for each value
  """
  n=5
  [0,0,0,0,0,0,0] n=1,2,3,4,5
  """
  dp[1]=1
  dp[2]=2
  for i in range(3,n+1):
    dp[i]=dp[i-1]+dp[i-2]
  return dp[n]

in_put=int(input(" "))
print(Climb(in_put))
"""
input: 1 or 2
output:Same

input:3 explanation --> 3=2+1 
output :3

Base Cases:
For n = 1, there is only one way to climb (1 step).
For n = 2, there are two ways to climb (1+1 or 2 steps).
Recursive Calculation:
For n = 3, it calculates climb(2) + climb(1) = 2 + 1 = 3.
For n = 4, it calculates climb(3) + climb(2) = 3 + 2 = 5.
For n = 5, it calculates climb(4) + climb(3) = 5 + 3 = 8.
For n = 6, it calculates climb(5) + climb(4) = 8 + 5 = 13.
For n = 7, it calculates climb(6) + climb(5) = 13 + 8 = 21.
For n = 8, it calculates climb(7) + climb(6) = 21 + 13 = 34.
For n = 9, it calculates climb(8) + climb(7) = 34 + 21 = 55.

"""
