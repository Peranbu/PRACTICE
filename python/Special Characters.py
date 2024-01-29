def special_characters(line):
  special=[]
  spaces=0
  for char in line:
    if char.isalnum()==False and char !=' ':
      special.append(char)
    elif char==' ':
      spaces+=1
  print(" Special characters",special)
  print("Length",len(special))
  print(" no of spaces",spaces)
special_characters(":this is a test line !@#$ ")
