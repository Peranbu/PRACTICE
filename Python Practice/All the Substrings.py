def Substring(str,n):
  for Len in range(1,n+1):
    for i in range(n-Len+1):
      j=i+Len-1
      for k in range(i,j+1):
        print(str[k],end=" ")
      print()

str="abc"
Substring(str,len(str))
      

str="abc"
Substring(str,len(str))

"""
output
a 
b 
c 
a b 
b c 
a b c 

"""

