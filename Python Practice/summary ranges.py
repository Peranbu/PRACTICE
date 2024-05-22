def summary(nums):
  if not nums:
    return []
  res=[]
  i=0
  j=0
  while j<len(nums):
    while j+1<len(nums) and nums[j]+1==nums[j+1]:
      j+=1
    if i==j:
      res.append(str(nums[i]))
    else:
      res.append(str(nums[i])+"->"+str(nums[j]))
    j+=1
    i=j
  return res

nums=list(map(int,input("enter").split(",")))
print(summary(nums))

"""
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]

[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]

[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
"""
