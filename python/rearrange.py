#input=[1 2 -1]
#output=[-1 1 2]
def compare_elements(x):
  return(x>=0,x)
def rearrange_elements(arr):
  arr.sort(key=compare_elements)
  return arr

user_input=input("Enter integers separated by spaces: ")
input_array=list(map(int,user_input.split()))
result_array=rearrange_array(input_array)
print("Rearranged array:", result_array)
