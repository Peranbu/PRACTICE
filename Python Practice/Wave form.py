def WaveSort(arr,n):
  arr.sort()
  for i in range(0,n-1,2):
    arr[i],arr[i+1]=arr[i+1],arr[i]
arr=list(map(int,input(",").split(",")))
WaveSort(arr,len(arr))
print(arr)

"""
#WaveSort-arr[0]>=arr[1]<=arr[2]>=arr[3]<=arr[4]>=…. B-S-B-S-B-S

input: 10,90,49,2,1,5,23
output: 2,1,10,5,49,23,90
"""

