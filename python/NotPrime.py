def is_prime(num):
  if num<2:
    return False
  for i in range(2,int(num**0.5)+1):
    if num%i==0:
      return False
    return True

def is_not_prime(a,b):
  print("the numbers between {a} and {b}")
  for num in range(a,b+1):
    if not is_prime(num)
    print(num,end=' ')

a = int(input("Enter the lower bound (a): "))
b = int(input("Enter the upper bound (b): "))
is_not_prime(a, b) 
