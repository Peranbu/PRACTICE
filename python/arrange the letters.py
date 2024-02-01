word=input("enter the words").lower()
normal_order=''.join(sorted(word))
print(" ",normal_order)
reverse_order=''.join(sorted(word,reverse=True))
print(" ",reverse_order)

