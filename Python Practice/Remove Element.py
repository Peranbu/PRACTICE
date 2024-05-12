def Remove(value,nums):
  i=0
  for x in nums:
    if x!=value:
      nums[i]=x
      i+=1
  return i

value=int(input(" "))
nums=list(map(int,input(" ").split(",")))
print(Remove(value,nums))

"""
input
nums=1,2,2,3,4,5,6
value=2
REMOVE 2 FROM THE ARRAY
1,3,4,5,6 --> Total=5
output:5
"""


