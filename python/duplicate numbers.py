#remove duplicate numbers
def remove_duplicate(numbers):
  unique_elements=list(set(numbers))
  return unique_elements

input_num=input(" ").split()
input_num=[int(num) for num in input_num]
result=remove_duplicate(input_num)
print(" ",result)
