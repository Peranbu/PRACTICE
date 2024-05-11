def anagram(str1,str2):
  str1=str1.replace(" ","").lower()
  str2=str2.replace(" ","").lower()
  return sorted(str1)==sorted(str2)

word1=input(" ")
word2=input(" ")
if anagrams(word1,word2):
  print("it is anagram")
else:
  print("not anagram")



def Anagram(s,t):
  if len(s)!=len(t):
    return False
  return sorted(list(s))==sorted(list(t))


