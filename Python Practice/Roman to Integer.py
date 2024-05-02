def conv(s):
    conversion={
        'I':1,
        'V':5,
        'X':10,
        'L':50,
        'C':100,
        'D':500,
        'M':1000
    }
    total=0
    highest_seen=0
    for c in reversed(s):
      value=conversion[c]
      if value<highest_seen:
        total-=value
      else:
        total+=value
    return total

roman=input("get input")
print("output",conv(roman))


