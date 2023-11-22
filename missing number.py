def missing_number(nums):
 n=len(nums)
 result=n
 for i in range(n): #interates through the given values
   result ^ = i ^ nums[i] #ex-or operation
   #same number 1^1=0
  return result
nums_str=input("enter the numbers:")
result=missing_numbers(nums)
print("the missing numbers:",result)    
