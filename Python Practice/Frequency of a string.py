Max=26
def Compress(s,n):
  freq=[0]*Max
  for i in range(n):
    freq[ord(s[i])-ord('a')]+=1
  for i in range(Max):
    if freq[i]!=0:
      print(chr(i+ord('a')),freq[i],end=" ")
      

s="geeksforgeeks"
n=len(s)
Compress(s,n)


"""
output

e 4 f 1 g 2 k 2 o 1 r 1 s 2 

"""
