def factorial(n):
  if n==0:
    return 1
  else:
    return n*factorial(n-1)
print(factorial(5))

def factorials(n):
  result=[]
  for i in range(1,n+1):
    result.append(factorial(n)) #for loop ends here next so be correct on next line indentation to print result correctly
  return result
print (factorials(5))
