def happy(n):
  def isFinish(n,seen):
    if n==1:
      return True
    if n in seen:
      return False
    seen.add(n)
    m=0
    while n!=0:
      r=n%10
      m+=r*r
      n=n//10
    return isFinish(m,seen)
  return isFinish(n,set())

n=int(input(" "))
print("output",happy(n))

"""
Input: n = 19
Output: true
Explanation:
1sq+ 9sq = 82
8sq + 2sq = 68
6sq + 8sq = 100
1sq+ 0sq + 0sq = 1
sq-squsre
"""
