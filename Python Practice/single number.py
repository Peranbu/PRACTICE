nums = list(map(int, input("Enter numbers separated by space: ").split(",")))
result = 0
for num in nums:
    result ^= num
print(result) 


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
