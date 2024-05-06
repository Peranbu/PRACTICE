"""
input : 1,2,3,4,5,-1,-3,-5
output:-5

number should be present in both positive and negative intger
"""

def Max(nums):
  c=-1
  if i in nums:
    i=i*-1
    if i in set(nums) and i>c:
      c=i
  return c

Nums=list(map(int,input(",").split(",")))
print(Max(Nums))

