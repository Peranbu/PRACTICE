def Flip(str):
  zero=0
  one=0
  for i in range(0,len(str)):
    ch=str[i]
    if(ch=="0"):
      zero+=1
    else:
      one+=1
  return (zero==1 or one==1)

if(Flip("110")):
  print("yes")
else:
  print("no")


"""
input:110
output:yes

0 flip to 1. Then string 111 

"""
