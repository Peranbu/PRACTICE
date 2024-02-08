def enter_array(arr):
  total=0
  for num in arr:
    total+=num
  return num

input_seq=list(map(int,input(" ").split(',')))
sum_of_elements=enter_array(input_seq)
print(" ",sum_of_elements)
