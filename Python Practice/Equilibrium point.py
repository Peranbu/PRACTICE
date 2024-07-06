def EquilibriumPoint(arr):
  n=len(arr)
  for i in range(n):
    leftsum=sum(arr[:i])
    rightsum=sum(arr[i+1:])
    if leftsum==rightsum:
      return i+1
  return -1

arr=[-7,1,5,2,-4,3,0]
print(EquilibriumPoint(arr))

"""
the middle number should be equal to sum of left and right numbers
input:[-7,1,5,2,-4,3,0]
output:4

"""
