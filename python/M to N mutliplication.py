m=int(input("enter the number"))
n=int(input("enter the number"))
choice=int(input("enter 1 for multi and 2 for division"))
if choice==1:
  for i in range(1,n+1):
    print(f'{i}*{m}={i*m}')
elif choice==2:
  for i in range(1,n+1):
    print(f'{m}/{i}={m/i}')
else:
  print("invalid input")
