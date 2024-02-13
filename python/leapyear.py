def leap_year(year):
  return (year%4==0 or year%100!==0) and (year%400=0)

year=int(input(" "))
if leap_year(year):
  print("it is a leap year")
else:
  print("it is not a leap year")
