--------LEETCODE----------
def index(nums):
  leftsum=0
  rightsum=sum(nums)
  for i in range(len(nums)):
    if leftsum==rightsum-nums[i]:#given condition in question
      return i
    leftsum+=nums[i]
    rightsum-=nums[i]
  return -1

nums=list(map(int,input(" ").split(",")))
print("output",index(nums))
"""
Input: nums = [2,3,-1,8,4]
Output: 3
2+3-1=4
lenght of array = 5-1 -> 4
"""

---------------NORMAL MIDDLE INDEX-------------------
def find_middle_index(nums):
    return len(nums) // 2

nums=list(map(int,input(" ").split(",")))
print("output",find_middle_index(nums))

"""
input:1,2,3,4,5
output:2
"""

