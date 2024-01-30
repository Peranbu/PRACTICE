def duplicate_numbers(arr):
  if len(arr)==0:
    return []
  else:
    result=[arr[0]]
    for i in range(1,len(nums)):
      if arr[i]!=arr[i-1]:
         result.append(arr[i])
    return result

array = [15, 14, 15, 23, 24, 26, 26, 45, 54, 45]
sorted_arr = sorted(array)
print("array =", duplicate_numbers(sorted_arr))
