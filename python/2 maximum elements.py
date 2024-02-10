def max_product(arr):
  if len(arr)<2:
    return "invalid input"
  arr.sort()
  maximum_pro=arr[-1]*arr[-2]
  minimum_pro=arr[0]*arr[1]
  if maximum_pro>inimum_pro:
    return arr[-1],arr[-2]
  else:
    return arr[0],arr[-1]

user_input=input("enter the number")
input_arr=list(map(int,user_input.split()))
result=max_product(input_arr)
print(" ",result)
