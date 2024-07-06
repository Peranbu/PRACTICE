def Fix(a):
  s=set()
  for i in range(len(a)):
    s.add(a[i])
  for i in range(len(a)):
    if i in s:
      a[i]=i
    else:
      a[i]=-1
  return a

a=[-1,-1,6,1,9,3,2,-1,4,-1]
print(" ",Fix(a))

"""
input: [-1,-1,6,1,9,3,2,-1,4,-1]
output:  [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]

Should replace the missing number with -1

"""
