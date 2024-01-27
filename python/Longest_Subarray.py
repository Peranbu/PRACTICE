def longest_array(nums):
  if len(nums)==0:
    return[]
  start=0
  max_start=0
  max_end=0
  max_lenght=1
  current_lenght=1
  for i in range(1,len(nums)):
    if nums[i]>nums[i-1]:
      current_lenght+=1
    else:
      if current_lenght>max_lenght:
        max_lenght=current_lenght
        max_start=start
        max_end=i-1
      current_lenght=1
      start=i
  if current_lenght>max_lenght:
    max_start=start
    max_end=len(nums)-1
  return nums[max_start:max_end+1]

nums=[1,2,3,4,1,2,3,4,5,6,7,2,3,5,6,7]
print(longest_array(nums))

    
