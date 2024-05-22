
def repeat(input_str):
  char=input_str[0]
  num=int(input_str[1:])
  return char*num

str1=input(" ")
str2=input(" ")
print(repeat(str1)+" "+repeat(str2))

"""
input:a3b3
output:aaabbb
"""
