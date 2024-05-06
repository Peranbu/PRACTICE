def Boats(people,limit):
  people.sort()
  left=0
  boat=0
  right=len(people)-1
  while left<right:
    if people[left]+people[right]<=limit:
      left+=1
    right-=1
    boat+=1
  return boat

people=list(map(int,input(" ").split(",")))
limit=int(input(" "))
print(Boats(people,limit))

