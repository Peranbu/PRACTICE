from collections import Counter
def find_most_common_array(arr):
  counter=Counter(arr)
  most_common_elements,count=counter.most_common(1)[0]
  return most_common_elements

array=[1,2,3,4,1,1,1,1,1]
most_common=find_most_common_array(array)
print(" ",most_common)
