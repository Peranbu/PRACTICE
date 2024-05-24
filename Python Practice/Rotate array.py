def Rotate(nums,k):
  n=len(nums)
  k%=n
  Reverse(nums,0,n-1)  #Reverse the whole array  1,2,3,4,5 -> 5,4,3,2,1     k=2
  Reverse(nums,0,k-1)  #Reverse the k elements   4,5,3,2,1
  Reverse(nums,k,n-1)  #Reverse the other elements  4,5,1,2,3
def Reverse(nums,start,end):
  while start<end:
    nums[start],nums[end]=nums[end],nums[start]
    start+=1
    end-=1

nums=list(map(int,input("input").split(",")))
k=int(input(" "))
Rotate(nums,k)
print("output",nums)

"""
input:1,2,3,4,5,6,7
k=3
output:4,5,6,1,2,3,4
"""
