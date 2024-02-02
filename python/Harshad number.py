def harshad(number):
  digits=[int(digit) for digit in str(number)]
  digits_sum=sum(digits)
  return number%digits_sum==0

num=int(input(" "))
if harshad(num):
  print("it is a harshad number")
else:
  print("it is not a harshad number")
  
