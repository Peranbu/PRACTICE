def bit(n):
  set_bit=0
  while n!=0:
    n &= n-1 #AND Gate 
    set_bit+=1
  return set_bit

n=int(input(" "))
print(bit(n))

"""
input:1011
output:8
"""
