def DefangIP(address):
  output=""
  for i in range(len(address)):
    if(address[i]=='.'):
      output+="[.]"
    else:
      output+=address[i]
  return output

address=input(" ")
print(DefangIP(address))


def DefangIP(address):
  new_address=address.replace('.','[.]')
  return new_address

address=input(" ")
print(DefangIP(address))

