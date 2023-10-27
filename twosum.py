def twosum(nums,target)
num_dict={}
 for i,num in enumerate(num):
 complement=target-num
   if complement in num_dict:
     return[num_dict{complement],i]
   num_dict[num]=i
return[]
num=[1,2,3,4,5,6]
target=7
result=twosum(num,target)
print(result)

#output
#2,3
