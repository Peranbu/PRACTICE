n = int(input("Enter a number: "))
for i in range(0, 31):
    if n == (2**i):
        print("True")
        break
else:
    print("False")
