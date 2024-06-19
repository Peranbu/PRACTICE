def Assign(arr,N):
  arr.sort()
  ans=[0]*N
  pos1=0
  pos2=N-1
  for i in range(N):
    if i%2==0:
      ans[i]=arr[pos2]
      pos2=pos2-1
    else:
      ans[i]=arr[pos1]
      pos1=pos1+1
  return ans

arr=list(map(int,input(" ").split(",")))
N=len(arr)
print("output",Assign(arr,N))

"""
input: 1,2,2,1
output:2,1,2,1

Even numbers should be greater than the next odd numbers

"""
