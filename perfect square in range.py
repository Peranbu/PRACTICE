#for square
def perfect_sq(n):
  return int(n**0.5)**2==n
def find_numbers(lower,upper):
  result=[num for num in range(lower,upper+1) if perfect_sq(num) and less_than_10(num)]
  return result
lower_number=int(input("enter the number"))
upper_number=int(input("enter the number"))
if(lower_number < 0 or upper_number < 0):
  print("invalid input")
else:
  print("the numbers are",find_numbers(lower_number,upper_number))
