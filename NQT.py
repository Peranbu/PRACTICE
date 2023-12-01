#Question 1
'''chocolate factory is packing chocolates into the packets. The chocolate packets here represent an array  of N number of integer values.
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
6 1 8 2 0 0'''

ANSWER
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

#Question 2
'''Problem Statement 
Joseph is learning digital logic subject which will be for his next semester. 
He usually tries to solve unit assignment problems before the lecture. Today he got one tricky question. The problem statement is “A positive integer has been given as an input.
Convert decimal value to binary representation.
Toggle all bits of it after the most significant bit including the most significant bit. 
Print the positive integer value after toggling all bits”.
Constrains-
1<=N<=100
Example 1:
Input :
10  -> Integer
Output :
5    -> result- Integer
Explanation:
Binary representation of 10 is 1010. After toggling the bits(1010), will get 0101 which represents “5”. Hence output will print “5”.'''

ANSWER                             #n=10
import math                        #math.log2() <-- to find the value next int(math.log2(n))<-- convert it into integer log2(10)=3.332 int(math.log2(n))=3
n=int(input())                     #add 1 into the value then << moving the 1 towards the left <<<---value of three 0001 converted into 10000=16 then 
k=(1<< int(math.log2(n))+1)-1      #(1<< int(math.log2(n))+1)-1=16-1=15(1111-maximum) 10(1010)^15(1111)=5
print(n^k)

#QUESTION 3
'''Airport security officials have confiscated several item of the passengers at the security check point. 
All the items have been dumped into a huge box (array). Each item possesses a certain amount of risk[0,1,2].
Here, the risk severity of the items represent an array[] of N number of integer values. The task here is to sort the items based on their levels of risk in the array.
The risk values range from 0 to 2.
  
Example :
Input :
7  -> Value of N
[1,0,2,0,1,0,2]-> Element of arr[0] to arr[N-1], while input each element is separated by new line.
Output :
0 0 0 1 1 2 2  -> Element after sorting based on risk severity 
Example 2:
input : 10  -> Value of N 
[2,1,0,2,1,0,0,1,2,0] -> Element of arr[0] to arr[N-1], while input each element is separated by a new line.
Output : 
0 0 0 0 1 1 1 2 2 2  ->Elements after sorting based on risk severity.
Explanation:
In the above example, the input is an array of size N consisting of only 0’s, 1’s and 2s. 
The output is a sorted array from 0 to 2 based on risk severity.'''
ANSWER
n=int(input())
arr=[]
input_str=input("Enter a list of integers separated by commas: ")
arr_str=input_str.split(',')
for num_str in arr_str:
    num=int(num_str)
    arr.append(num)
for i in sorted(arr):
    print(i,end="  ")

  
