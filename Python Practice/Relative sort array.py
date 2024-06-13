def arr(arr1,arr2):
  result=[]
  not_in_arr2=[]
  for num in arr2:
    while num in ar1:
      result.append(num)
      arr1.remove(num)
  for num in arr1:
    not_in_arr2.append(num)
  not_in_arr2.sort()
  return result+not_in_arr2

arr1=int(input(" "))
arr2=int(input(" "))
print(" ",arr(arr1,arr2))


"""
Example 1:
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]  ---> common numbers in arr1 and arr2 + remaining elements(sorted)

Example 2:
Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]

"""
