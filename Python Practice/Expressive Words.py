def Expressive(words,s):
  def check(stretch,word):
    i=0
    j=0
    while i<len(stretch) and j<len(word):
      if stretch[i]!=word[j]:
        return False
      len_s=1
      while i+1<len(stretch) and stretch[i]==stretch[i+1]:
        i+=1
        len_s+=1
      len_w=1
      while j+1<len(word) and word[j]==word[j+1]:
        j+=1
        len_w+=1
      if (len_s!=len_w and len_s<3) and len_s!=len_w:
        return False
      i+=1
      j+=1
    return i==len(stretch) and j==len(word)
  return sum(check(s,word) for word in words)


s = input("Enter the string s: ")
words_input = input("Enter the list of words separated by spaces: ")
words = words_input.split()
# Call the function and print the result
result = Expressive(words, s)
print(f"Output: {result}")


"""
Input: s = "heeellooo", words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.

Example 2:
Input: s = "zzzzzyyyyy", words = ["zzyy","zy","zyy"]
Output: 3
