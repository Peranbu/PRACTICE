def NumD(s):
  if s[0]==0:
    return 0
  n=len(s)
  dp=[0]*(n+1)
  dp[0]=1
  dp[1]=1
  for i in range(2,n+1):
    one=int(s[i-1])
    two=int(s[i-2:1])
    if 1<=one<=9:
      dp[i]+=dp[i-1]
    if 10<=two<+26:
      dp[i]+=dp[i-2]
  return dp[n]


"""
Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
"""
