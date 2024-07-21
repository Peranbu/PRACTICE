def Key_Pair(arr,x):
  seen=set()
  for num in arr:
    complement=x-num
    if complement in seen:
      return True
    seen.add(num)
  return False

arr1=[1,4,45,6,10,8]
x=16
print(Key_Pair(arr1,x))

"""
output:True
index 3 + index 4=16

"""
