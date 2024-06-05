from math import inf
def MaxSubArray(nums):
  current_max=0
  overall_max=-inf
  for num in nums:
    current_max=max(current_max+num,num)
    overall_max=max(overall_max,current_max)
  return overall_max

nums=list(map(int,input(" ").split(",")))
print("output",MaxSubArray(nums))

"""
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
"""
