def sort012(arr,arr_size):
  low=0
  high=arr_size-1
  mid=0
  while mid<=high:
    if arr[mid]==0:
      arr[low],arr[mid]=arr[mid],arr[low]
      low+=1
      mid+=1
    elif arr[mid]==1:
      mid+=1
    else:
      arr[mid],arr[high]=arr[high],arr[mid]
      high-=1
  return arr
def printarr(arr):
  for k in arr:
    print(k,end=" ")

arr=[1,0,2,1,0,1,0]
arr_size=len(arr)
sorted_arr=sort012(arr,arr_size)
printarr(sorted_arr)

"""
input:0,2,1,2,1,0
output:0,0,1,1,2,2

"""

