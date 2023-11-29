A chocolate factory is packing chocolates into the packets. The chocolate packets here represent an array  of N number of integer values.
The task is to find the empty packets(0) of chocolate and push it to the end of the conveyor belt(array).
Example 1 :
N=8 and arr = [4,5,0,1,9,0,5,0].
There are 3 empty packets in the given set. These 3 empty packets represented as O should be pushed towards the end of the array
Input :
8  – Value of N
[4,5,0,1,9,0,5,0] – Element of arr[O] to arr[N-1],While input each element is separated by newline
Output:
4 5 1 9 5 0 0 0
Example 2:
Input:
6 — Value of N.
[6,0,1,8,0,2] – Element of arr[0] to arr[N-1], While input each element is separated by newline
Output:
6 1 8 2 0 0

#enter total numbers
n=int(input("enter the number of values"))
j=0
l=[0 for i in range(n)]
#enter the numbers
numbers=input("enter the numbers")
values=[int(x) for x in numbers.split(',')]
for a in values:
  if a!=0:
    l[j]=a
    j+=1
for i in l:
  print(i,end=" ")
