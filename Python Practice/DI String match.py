def DIString(s):
  n=len(s)
  result=[]
  initial=0
  final=n
  for i in range(n):
    if s[i]=="I":
      result.append(initial)
      initial+=1
    else:
      result.append(final)
      final-=1
  result.append(initial)
  return result

s=input(" ")
print(DIString(s))

"""
I-increase
D-decrease
Input: “DID”
Explanation: The first character is ‘D’, so the first two numbers should be decreasing. 
The next character is ‘I’, so the next number should be larger. The last character is ‘D’, so the final number should be smaller.
Possible Output: [2, 0, 3, 1]
In this output, 2 > 0 (for the first ‘D’), 0 < 3 (for the ‘I’), and 3 > 1 (for the last ‘D’).

Input: “II”
Explanation: Both characters are ‘I’, so the numbers should be increasing.
Possible Output: [0, 1, 2]
In this output, 0 < 1 (for the first ‘I’) and 1 < 2 (for the second ‘I’).

Input: “DDI”
Explanation: The first two characters are ‘D’, so the first three numbers should be decreasing.
The last character is ‘I’, so the final number should be larger.
Possible Output: [3, 2, 0, 1]
In this output, 3 > 2 (for the first ‘D’), 2 > 0 (for the second ‘D’), and 0 < 1 (for the ‘I’).
"""
