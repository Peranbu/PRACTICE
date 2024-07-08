def Computer(st,n):
  Reverse_Alphabet="zyxwvutsrqponmlkjihgfedcba"
  l=len(st)
  answer=""
  for i in range(0,n):
    answer=answer+st[i]
  for i in range(n,l):
    answer=(answer+Reversed_Alphabets[ord(st[i])-ord("a")])
  return answer
  
st="pneumonia"
n=4
answer=Computer(st,n-1)
print(answer)

"""
input:"pneumonia"
from 4th letter we have to mirror the character
output:pnefnlmrz

"""
