def Alternative_Sum(n):
  Total_sum=0
  n=str(n)
  for i in range(len(n)):
    if i%2==0:
      Total_sum+=int(n[i])
    else:
      Total_sum-=int(n[i])
  return sum

n=int(input(" "))
print(Alternative_Sum(n))


"""
input:231
2-1+3
output:4
"""

