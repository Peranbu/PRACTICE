def special_character(input):
  for char in input:
    if char.isalnum():
      continue
    else:
      print(char,end=" ")

input_string=input(" ")
special_character(input_string)
