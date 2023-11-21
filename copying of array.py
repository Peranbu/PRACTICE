def copy_array(source,destination):
  if len(source)!=len(destination):
    print("the arrays should be equal so enter a valid input")
    return 
  for i in range(len(source)):
   destination[i]=source[i]
source_array=[1,2,3,4,5]
destination_array=[0,0,0,0,0]
print("source array",source_array)
print("destination array before copying",destination_array)
copy_array(source_array,destination_array)
print("destination array after copying",destination_array)
