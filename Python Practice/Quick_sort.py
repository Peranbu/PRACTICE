def Quick_Sort(arr):
  if len(arr)<1:
    return arr
  else:
    pivot=arr[len(arr)//2]
    left=[]
    middle=[]
    right=[]
    for x in arr:
      if x<pivot:
        left.append(x)
      elif x==pivot:
        middle.append(x)
      else:
        right.append(x)
    return Quick_Sort(left)+middle+Quick_Sort(right)

arr=list(map(int,input(" ").split(",")))
print("output",Quick_Sort(arr))

"""
input:5,4,3,2,1
output:1,2,3,4,5

"""

