def Zeros(arr):
  j=0
  for i in range(len(arr)):
    if arr[i]!=0:
      arr[i],arr[j]=arr[j],arr[i]
      j+=1

arr=list(map(int,input(" ").split(",")))
print("output",Zeros(arr))


"""
input:2,0,1,0,3,0
output:2,1,3,0,0,0

"""
