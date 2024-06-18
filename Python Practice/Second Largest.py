def Find(array):
  if len(array)<2:
    return none
  first=second=float('-inf')
  for n in array:
    if n>first:
      second=first
      first=n
    elif first>n>second:
      second=n
  if second!='-inf':
    return second
  else:
    return none

array=list(map(int,input(" ").split(",")))
print("second largest",Find(array))

"""
input:2,3,1,5,4
output: Second largest:4

"""
      
