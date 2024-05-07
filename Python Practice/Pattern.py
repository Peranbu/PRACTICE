def Pattern(S):
  length=len(S)
  for i in range(length):
    for j in range(length):
      if i==j or i+j==length-1:
        """
        i==j checks top left to bottom right diagonal
        i+j==length-1 checks top right to bottom left 
        """
        print(s[j],end=' ')
      else:
        print(' ',end=' ')
    print()

s=input(" ")
Pattern(s)

"""
INPUT : PROGRAM
OUTPUT
P           M 
  R       A   
    O   R     
      G       
    O   R     
  R       A   
P           M 
"""

