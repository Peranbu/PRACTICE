def BubbleSort(arr):
  n=len(arr)
  for i in range(n):
    swapped=False
    for j in range(n-i-1):
      if arr[j]>arr[j+1]:
        arr[j],arr[j+1]=arr[j+1],arr[j]
        swapped=True
      else:
        return False
  return arr

arr=list(map(int,input(" ").split(",")))
print("output",",".join(map(str,BubbleSort(arr)))) 
#","join(map(str,BubbleSort(arr))) to remove [1,2,21] -> 1,2,21

"""

arr=1,21,2
output:1,2,21

"""
