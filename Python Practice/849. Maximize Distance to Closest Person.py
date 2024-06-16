def Closest(seats):
  count=0
  mx=0
  ma=seats.index(1)
  for i in seats:
    if i==0:
      count+=1
    else:
      mx=max(count,mx)
      count=0
  if mx%2==0:
    m=mx//2
  else:
    m=mx//2+1
  return max(m,ma,count)


seats=list(map(int,input(" ").split(",")))
print("output",Closest(seats))

""'
Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
"""
  
