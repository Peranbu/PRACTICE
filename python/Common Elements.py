def find_common_elements(arr1,arr2):
  return list(set(arr1)&set(arr2))

array1=[1,2,3,4,5]
array2=[3,4,5,6,7]
common_elements=find_common_elements(array1,array2)
print(" ",common_elements)
