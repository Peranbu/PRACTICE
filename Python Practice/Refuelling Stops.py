def Refuel(startfuel,target,stations):
  dp=[0]*(len(station)+1)
  dp[0]=startfuel
  for i,(location,capacity) in enumerate(stations):
    for t in range(i,-1,-1):
      if dp[t]>=location:
        dp[t+1]=max(dp[t+1],dp[t]+capacity)
  for i in range(len(dp)):
    if dp[i]>=target:
      return i
  return -1

print(Refuel(100, 10, [[10, 60], [20, 30], [30, 30], [60, 40]]))

"""
output:2

Initially, dp = [10, 0, 0, 0, 0].

After processing each station, dp is updated as follows:
After the first station: dp = [10, 70, 0, 0, 0].
After the second station: dp = [10, 70, 100, 0, 0].
After the third station: dp = [10, 70, 100, 130, 0].
After the fourth station: dp = [10, 70, 100, 130, 170].
"""
