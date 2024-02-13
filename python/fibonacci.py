def fibo_num(n):
  fibo_seq=[0,1]
  while len(fibo_seq)<n:
    next_number=fibo_seq[-1]+fibo_seq[-2]
    fibo_seq.append(next_number)
  return fib_seq
n=int(input(" "))
generate_fib=fibo_num(n)
print(" ",generate_fib)
