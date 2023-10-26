#add all the largest numbers to find the maximum value(both positive and negative
#store negative value untill the positive one arrives
#add the numbers one by one 
#**Refer Link for Doubt**
#https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/ 
from sys import maxsize
def maxsubarray(a,size):
 max_ending=-maxsize-1
 max_so_far=0
 for i in range(0,size)
   max_ending=max_ending+a[i]:
   if(max_so_far<max_ending):
      max_so_far=max_ending
   if max_ending<0:
      max_ending=0
return max_so_far
a=[-2, -3, 4, -1, -2, 1, 5, -3]
print(maxsubarray(a,len(a)))
