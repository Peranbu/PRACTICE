def HasCycle(head):
  tester=set()
  if head in tester:
    return True
  tester.add(head)
  head=head.next
return False



"""
https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150
"""
