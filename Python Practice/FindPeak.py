def FindPeak(arr,n):
  if(n==1):
    return 0
  if(arr[0]>=arr[1]):
    return 0
  if(arr[n-1]>=arr[n-2]):
    return n-1
  for i in range(1,n-1):
    if(arr[i]>=arr[i-1] and arr[i]>=arr[i+1]):
      return i

arr=[1,2,20,4,1,0]
n=len(arr)
print(" ",FindPeak(arr,n))\

"""
input:1,2,20,4,1,0
output: index:2

a number should be graater the neighbouring numbers

20>2 and 20>4
index:2

"""

      
