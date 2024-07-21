def Swap_count(s):
  swap=0
  imbalance=0
  for i in s:
    if i=="[":
      imbalance-=1
    else:
      imbalance+=1
      if imbalance>0:
        swap+=imbalance
  return swap

s="[]][]["
print(Swap_count(s))

"""
output:2
First swap: Position 3 and 4
[][]][
Second swap: Position 5 and 6
[][][]


"""
