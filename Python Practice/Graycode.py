def GrayCode(n):
result=[]
for i in range(1<<n):
  gray=i^(i>>i)
  result.append(gray)
return result

n=int(input(" "))
print("output",GrayCode(n))

"""
For i=0:
Binary Representation: 0 is 0000 in binary.
Right Shift by 1: 0 >> 1 is 0000.
Bitwise XOR: 0000 ^ 0000 is 0000.
Decimal Result: 0000 is 0.
So, the Gray code for 
i=0 is 0.

For i=1:
Binary Representation: 1 is 0001 in binary.
Right Shift by 1: 1 >> 1 is 0000.
Bitwise XOR: 0001 ^ 0000 is 0001.
Decimal Result: 0001 is 1.
So, the Gray code for 
i=1 is 1.

For i=2:
Binary Representation: 2 is 0010 in binary.
Right Shift by 1: 2 >> 1 is 0001.
Bitwise XOR: 0010 ^ 0001 is 0011.
Decimal Result: 0011 is 3.
So, the Gray code for 
i=2 is 3.

For i=3:
Binary Representation: 3 is 0011 in binary.
Right Shift by 1: 3 >> 1 is 0001.
Bitwise XOR: 0011 ^ 0001 is 0010.
Decimal Result: 0010 is 2.
So, the Gray code for 
i=3 is 2.

Resulting Sequence
Combining the results from above, we get the Gray code sequence for 
i=0 to i=3:

i=0 → Gray code: 0
i=1 → Gray code: 1
i=2 → Gray code: 3
i=3 → Gray code: 2
Full Sequence and Explanation
This approach ensures that only one bit changes between each consecutive Gray code value. The resulting sequence 0, 1, 3, 2 can be visualized as:
"""
