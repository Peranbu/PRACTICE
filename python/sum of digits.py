def sum_of_digits(n):
  total_sum=0
  while n>0:
    total_sum+=n%10
    n//=10
  if n > 0 and n<9:
    total_sum=sum_of_digits(total_sum)
  return total_sum

n=int(input("N"))
num=int(input(" number"))
if n >0 and n<9:
  print("the sum of digits",sum_of_digits(num))
else:
  print("invalid input")
    
