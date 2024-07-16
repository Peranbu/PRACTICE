def Leftrotate(s,d):
  tmp=s[d:]+[0:d]
  return tmp
def Rightrotate(s,d):
  tmp=s[-d:]+[:-d]
  return tmp

str1="Geeks for Geeks"
print(Leftrotate(str1,2))
print(Rightrotate(str1,2))

"""
output

eks for GeeksGe
ksGeeks for Gee

"""

