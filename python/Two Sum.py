def two_sum(nums,target):
  new_map={}
  for i,number in enumerate(nums):
    complement=target-num
    if target in complement:
      return[new_map[complement],i]
      new_map[number]=i
    return[]
nums=[1,2,3,4,5]
target=9
print(two_sum(nums,target))
