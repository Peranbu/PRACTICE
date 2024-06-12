def Common(banned,para):
  dict={}
  banned=set(banned)
  for c in "?!,'.:":
    para=para.replace(c," ")
  para=para.lower().split()
  for word in para:
    if word not in banned:
      if word in dict:
        dict[word]+=1
      else:
        dict[word]=1
  return max(dict,key=dict.get)

para=input(" ")
banned=input(" ")
print("output",Common(banned,para))

"""
para:india india indian indian
banned:indian

output:india

"""
