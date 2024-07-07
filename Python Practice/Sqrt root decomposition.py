arr=[0]*10000
def query(l,r):
  sum=0
  for i in range(l,r+1):
    sum+=arr[i]
  return sum
input_arr=[1,5,2,4,6,1,3,5,7,10]


arr[:len(input_arr)]=input_arr
"""
Alternative for above line

for i in range(len(input_arr)):
  arr[i]=input_arr[i]
"""


print("query(3,8)",query(3,8))



"""
Add all the numbers starting from index 3 upto index 8
input_arr=[1,5,2,4,6,1,3,5,7,10]
output:26
"""


