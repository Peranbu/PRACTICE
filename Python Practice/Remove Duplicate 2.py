def RemoveDupli(nums):
  j=1
  for i in range(1,len(nums)):
    if j==1 or nums[i]=nums[j-2]:
      nums[j]=nums[i]
      j+=1
  return j

nums=list(map(int,input(" ").split(",")))
print(RemoveDupli(nums))

"""
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]

Each number should not exceed more than 2 numbers
if 1,1,1,1 output:1,1
"""
