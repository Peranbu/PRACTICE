def SearchPattern(pattern,text):
  n=len(pattern)
  m=len(text)
  for i in range(m-n+1):
    j=0
    while j<n and text[i+j]==pattern[j]:
      j+=1
    if j==n:
      print(f"pattern index{i}")

text="agr"
pattern="gr"
SearhPattern(pattern,text)


"""
output:Pattern found at inedx 1

"""
