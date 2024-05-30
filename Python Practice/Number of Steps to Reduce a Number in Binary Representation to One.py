def Binary(s):
  steps=0
  carry=0
  n=len(s)-1
  for i in range(n,0,-1):
    if int(s[i])+carry==1:
      carry=1
      steps+=2
    else:
      steps+=1
  return steps+carry

s=input(" ")
print("output",Binary(s))

"""
the binary string s = "1101" 

Initial values:
s = "1101"
steps = 0
carry = 0
n = 3 (index of the last character)

Iteration 1:
i = 3
s[3] = '1'
int(s[3]) + carry = 1 + 0 = 1
Since 1 is odd, set carry = 1 and steps += 2
steps = 2

Iteration 2:
i = 2
s[2] = '0'
int(s[2]) + carry = 0 + 1 = 1
Since 1 is odd, set carry = 1 and steps += 2
steps = 4

Iteration 3:
i = 1
s[1] = '1'
int(s[1]) + carry = 1 + 1 = 2
Since 2 is even, steps += 1
steps = 5

Final steps:
The loop is done, and we add the carry to steps
steps + carry = 5 + 1 = 6
So, for the binary string "1101", it takes 6 steps to reduce it to 1

output:6
"""
