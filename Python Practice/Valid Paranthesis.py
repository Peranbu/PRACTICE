def valid(b):
  stack=[]
  for a in b:
    if a in '({[':
      stack.append(a)
    else:
      if not stack or \
      (a==')' and stack[-1]!='(') or \
      (a=='}' and stack[-1]!='{') or \
      (a==']' and stack[-1]!='['):     #: is important
        return False
      stack.pop()
  return not stack

b=input("")
print(valid(b))


"""
initialize stack
for loop to interate through the input
loop to find '({[' in input
if found append i.e.,) insert it into stack
else 
get the last element out of stack and compare with end brackets i.e.,) '}])'
if both are valid( [] = remove it from the stack)
if stack=0 it is true else False
https://www.youtube.com/watch?v=YwvHeouhy6s ---------->  explanation with differnet code . the above code can also be written
"""
