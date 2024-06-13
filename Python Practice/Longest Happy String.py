def Happy(a,b,c):
  s=[[a,'a'],[b,'b'],[c,'c']]
  ans=[]
  while True:
    s.sort()
    i=1 if len(ans)>=2 and ans[-2]==ans[-1]==s[2][1] else 2 #compare last 2 elements of ans and s wheather it is large number or not
    if s[i][0]:
      ans.append(s[i][1])
      s[i][0]-=1
    else:
      break
  return ''.join(ans)

a=int(input(" "))
b=int(input(" "))
c=int(input(" "))
print("output",Happy(a,b,c))

"""
Let's take an example with a = 1, b = 1, and c = 7.

Initial s = [[1, 'a'], [1, 'b'], [7, 'c']]
Sort s: [[1, 'a'], [1, 'b'], [7, 'c']] (already sorted)

First iteration:
len(ans) < 2 is True, so i = 2
Append 'c' to ans: ans = ['c']
Decrement count: s = [[1, 'a'], [1, 'b'], [6, 'c']]

Second iteration:
Sort s: [[1, 'a'], [1, 'b'], [6, 'c']]
len(ans) < 2 is True, so i = 2
Append 'c' to ans: ans = ['c', 'c']
Decrement count: s = [[1, 'a'], [1, 'b'], [5, 'c']]

Third iteration:
Sort s: [[1, 'a'], [1, 'b'], [5, 'c']]
len(ans) >= 2 and ans[-2] == ans[-1] == 'c' is True, so i = 1
Append 'b' to ans: ans = ['c', 'c', 'b']
Decrement count: s = [[1, 'a'], [0, 'b'], [5, 'c']]
Fourth iteration:

Sort s: [[0, 'b'], [1, 'a'], [5, 'c']]
len(ans) >= 2 is False, so i = 2
Append 'c' to ans: ans = ['c', 'c', 'b', 'c']
Decrement count: s = [[0, 'b'], [1, 'a'], [4, 'c']]
Continue this process until the loop breaks when no more characters can be appended without violating the rules or running out of characters.

Final Output
The function will return a string that is the longest possible without having three consecutive identical characters, such as "ccbccacc"
"""


              
