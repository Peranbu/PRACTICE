def Robb(nums):
  odd=0
  even=0
  for i in nums:
    temp=max(odd+i,even)
    odd=even
    even=temp
  return even

nums=list(map(int,input(" ").split(",")))
print("out",Robb(nums))

"""
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

add alternative numbers to get the output
 """
