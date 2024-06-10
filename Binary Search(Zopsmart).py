def Binary(arr,low,high,r):
  while low<=high:
    mid=low+(high-low)//2
    if arr[mid]==r:
      return mid
    elif arr[mid]<r:
      low=mid+1
    else:
      high=mid-1
  return -1

arr=list(map(int,input(" ").split(",")))
r=int(input(" "))
result=Binary(arr,0,len(arr)-1,r)
if result!=-1:
  print(" ",result)
else:
  print("not found")


"""
 arr=1,2,3,4,5
 r=3
output: 2
"""
