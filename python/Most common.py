#import collection method
from collections import Counter
user_input=input("enter the input")
list=[int(num) for num in user_input.split(',')]
c=Counter(list)
most_common_element=c.most_common(1)[0][0]
print("the most common",most_common_elements)


#using if/else
input
list=[int(num) for num in user_input.split(',')]
element_count={}
for num in element_count:
  if num in element_count:
    element_count[num]+=1
  else:
    element_count[num]=1
most_common_elements=max(element_count,key=element_count.get)
print(" ",most_common_element)
