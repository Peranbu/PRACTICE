def lcs(x,y,m,n):
  if m==0 or n==0:
    return 0
  elif x[m-1]==y[n-1]:
    return 1+lcs(x,y,m-1,n-1)
  else:
    return max(lcs(x,y,m-1,n),lcs(x,y,m,n-1))
def SuperSequence(x,y):
  x=len(m)
  y=len(n)
  return m+n-2

x="geek"
y="eke"
print(SuperSequence(x,y))

"""
input:

x="geek"
y="eke"

output:5

"""


