def Anagram(s,t):
  if len(s)!=len(t):
    return False
  return sorted(list(s))==sorted(list(t))

s=input(" ")
t=input(" ")
print(Anagram(s,t))

