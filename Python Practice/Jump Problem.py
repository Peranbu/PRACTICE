def Jump(nums):
  max_reach=0
  for i,jump in enumerate(nums):
    if i>max_reach:
      return False
    max_reach=max(max_reach,i+jump)
  return True

nums=[3,2,1,0,4]
print(Jump(nums))

"""
index 0 is 3 and it can reach upto index 3 i.e.,) 2,1,0
the numbers within index 3 should be able to reach the final index of index 4
in this case it cannot reach it . output : False

https://youtu.be/HCQW6fmo2l8?si=r0Zl2kOLHLqzQ2MI

"""
