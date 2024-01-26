def max_diff(arr):
  if len(arr)<2:
    return none
  arr.sort()
  min_val=arr[0]
  max_diff=0
  for num in arr[1:]:
    if num-min_val>max_diff:
      max_diff=num-min_val
    if num<min_val:
      num=min_val
  return max_diff

arr=[2,3,4,1,6,13,12,18,15]
print(max_diff(arr))
