def Find3Numbers(arr,arr_size,target_sum):
  for i in range(arr_size-2):
    for j in range(i+1,arr_size-1):
      for k in range(j+1,arr_size):
        if arr[i]+arr[j]+arr[k]==target_sum:
          print("output",arr[i],arr[j],arr[k])
          return True
  return False

A=[1,4,45,6,10,8]
sum_value=22
arr_size=len(A)
if not Find3Numbers(A,arr_size,sum_value):
  print("not found")

"""
input:1,4,45,6,10,8
target:22
output:4,10,8

"""

  
