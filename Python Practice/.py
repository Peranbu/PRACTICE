def Unique(nums):
  nums.sort()
  ans=0
  nxt=nums[0]+1
  for i in range(1,len(nums)):
    if nxt>=nums[i]+1:
      ans+=nxt-nums[i]
      nxt+=1
    else:
      nxt=nums[i]+1
  return ans

nums=list(map(int,input().split(",")))
print("output",Unique(nums))

"""
Example 1:
Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].

Example 2:
Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.

"""
