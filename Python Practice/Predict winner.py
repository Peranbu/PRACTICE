def winner(nums):
  n=len(nums)
  def dfs(i,j):
    if i==j:
      return nums[i]
    left_diff=nums[i]-dfs(i+1,j)
    right_diff=nums[j]-dfs(i,j-1)
    return max(left_diff,right_diff)
  return dfs(0,n-1)>=0

nums=list(map(int,input(" ").split(",")))
print(" ",winner(nums))

"""
Input: nums = [1,5,2]
Output: false
Explanation: Initially, player 1 can choose between 1 and 2.(first or last onlyy)
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return false.

Input: nums = [1,5,233,7]
Output: true
Explanation: Player 1 first chooses 1. Then player 2 has to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.

https://www.youtube.com/watch?v=OO7KUGUJHRs
"""
