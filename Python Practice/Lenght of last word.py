def lenWord(s):
  x=s.strip()
  count=0
  for i in range(len(x)):
    if x[i]==" ":
      count=0
    else:
      count+=1
  return count

s=input(" ")
print("output",lenWord(s))

"""
s="I am from India"
output:5
"""

