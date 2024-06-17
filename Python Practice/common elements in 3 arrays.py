def Common(arr1,arr2,arr3,n1,n2,n3):
  i=0
  j=0
  k=0
  common_elements=[]
  while i<n1 and j<n2 and k<n3:
    if arr1[i]==arr2[j] and arr2[j]==arr3[k]:
      common_elements.append(arr1[i])
      i+=1
      j+=1
      k+=1
    elif arr1[i]<arr2[j]:
      i+=1
    elif arr2[j]<arr3[k]:
      j+=1
    else:
      k+=1
  return common_elements
  
arr1=list(map(int,input(" ").split(",")))
arr2=list(map(int,input(" ").split(",")))
arr3=list(map(int,input(" ").split(",")))
n1=len(arr1)
n2=len(arr2)
n3=len(arr3)
print("output",Common(arr1,arr2,arr3,n1,n2,n3))

"""
input: 1,2,3,4,5
       2,3,4,5,6
       3,4,5,6,7
output: 3, 4, 5

"""
