#number divisible by 2,3,5

def UglyNumber(n):
  if n<0:
    return False
  for i in [2,3,5]:
    while n%i==0:
      n=n/i
  return n==1
input=UglyNumber(126)
print(input)
