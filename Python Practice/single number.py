#To get list input 1,2,3,4,1,2,3   
#output=4
nums = list(map(int, input("Enter numbers separated by space: ").split(",")))
result = 0
for num in nums:
    result ^= num
print(result) 



#To get input like [1,2,3,4,1,2,3]
#output=4
import ast
def singleNumber(nums):
    result = 0
    for num in nums:
        result ^= num
    return result
# Get input from the user
nums = ast.literal_eval(input("Enter numbers  "))
# Test the function
print(singleNumber(nums))
