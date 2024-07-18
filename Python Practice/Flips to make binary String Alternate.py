def Flip(ch):
  if ch=='0':
    return '1'
  else:
    return '0'
def Flip_str(s,expected):
  Flip_count=0
  for i in range(len(str)):
    if s[i]!=expected:
      Flip_count+=1
    expected=Flip(expected)
  return Flip_count
def Min_Flip(s):
  return min(Flip_str(s,'0'),Flip_str(s,'1'))

str_1="0001010111"
print(Min_Flip(str_1))

"""
the string should be in alternative numbers

input:"0001010111"
output:"0101010101
         F      F
F-Flip

number of flip=2
output:2


"""
