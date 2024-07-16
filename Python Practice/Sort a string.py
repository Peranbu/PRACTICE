#without using sort()
Max_char=26
def Stringsort(str):
  CharCount=[0 for i in range(Max_char)]
  for i in range(0,len(str),1):
    CharCount[ord(str[i])-ord('a')]+=1
  for i in range(0,Max_char,1):
    for j in range(0,CharCount[i],1):
      print(chr(ord('a')+i),end="")

s="geeksforgeeks"
Stringsort(s)

"""
output:

sorted array : eeeefggkkorss

"""
