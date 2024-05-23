def RemoveDupli(nums):
  index=1
  nums.sort()
  for i in range(1,len(nums)):
    if nums[i-1]!=nums[i]:
      nums[replace]=nums[i]
      replace+=1
  return replace

nums=list(map(int,input(" ").split(",")))
print(RemoveDupli(nums))

"""
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Output will only print the total numbers

https://www.youtube.com/watch?v=oMr9lehS7Us&t=162s
"""
