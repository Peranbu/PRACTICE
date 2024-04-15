def addTwoNumbers(l1, l2):
    num1=int(''.join(str(i)for i in l1[::-1]))
    num2=int(''.join(str(i)for i in l2[::-1]))
    total=num1+num2
    return [int(i) for i in str(total)[::-1]]
# Get input from the user
l1=list(map(int, input("1St Number").split(',')))
l2=list(map(int, input("2nd Number").split(',')))
# Add the two numbers and print the result
result=addTwoNumbers(l1,l2)
print("The sum is:",result)


"""#simple Addition using Linkedlist
1  2  3
4  5  6 
Output:
5  7  9
"""
