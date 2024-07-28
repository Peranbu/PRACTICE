def is_palindrome(i,j,string):
    while i<j:
        if string[i]!=string[j]:
            return False
        i+=1
        j-=1
    return True
def Min_palindrome(i,j,string):
    if i>=j or is_palindrome(i,j,string):
        return 0
    ans=float('inf')
    for k in range(i,j):
        left=Min_palindrome(i,k,string)
        right=Min_palindrome(k+1,j,string)
        count=left+right+1
        ans=min(count,ans)
    return ans

str="geek"
print("Minimum cuts needed:", Min_palindrome(0, len(str) - 1, str))

"""
output: minimum cuts required 2


"""


