def Twosum(nums,target):
  num_dict={}
  for i,num in enumerate(nums):
    complement=target-num
    if complement in num_dict:
      return[num_dict[complement],i]
    num_dict[i]=num
  return []


nums=[1,2,3,4,5]
target=7
result=Twosum(nums,target)
print(result)
