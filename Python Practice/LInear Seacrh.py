def Linear_Search(arr,target):
  for i in range(len(arr)):
    if arr[i]==target:
      return i
  return -1

arr=list(map(int,input(" ").split(",")))
target=int(input(" "))
print("the index",Linear_Search(arr,target))

"""
arr=3,2,1,5,4,6
target=5
output:3

"""
