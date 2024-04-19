#Correct
def Buyticket(ticket,k):
  c=0
  while True:
   if ticket[k]==0:
     break
   for i in range(len(ticket)):
     if ticket[i]>0:
       ticket[i]-=1
       c+=1
  return c

n=int(input(" "))
ticket=list(map(int,input(" "))).split(",")
k=int(input(" "))
print(Buyticket(ticket,k))



#LEETCODE ANSWER
def Buyticket(ticket,k):
  c=0
  while True:
   if ticket[k]==0:
     break
   for i in range(len(ticket)):
     if ticket[k]==0:
       break
     if ticket[i]>0:
       ticket[i]-=1
       c+=1
  return c

"""
Explanation given in pdf name : Time needed to buy ticket(leetcode)
"""

