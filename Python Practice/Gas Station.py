def Gas_Station(gas,cost):
  if sum(gas)<sum(cost):
    return -1
  cur_tank=0
  start=0
  n=len(gas)
  for i in range(n):
    cur_tank+=gas[i]-cost[i]
    if cur_tank<0:
      start=i+1
      cur_tank=0
  return start

gas=list(map(int,input(" ").split(",")))
cost=list(map(int,input(" ").split(",")))
print(" ",Gas_Station(gas,cost))

"""
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
at index 3 gas=4 and cost=1
output:gas-cost --> 3
other index from the gas cannot be subtracted from cost because the output will be in negative
"""
