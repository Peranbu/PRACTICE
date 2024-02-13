#Prime Numbers
def prime_numbers(n):
  primes=[]
  num=2
  while len(primes)<n:
    if all(num%i!=0 for i in range(2,int(n**0.5)+1)):
      primes.append(num)
    num+=1
  return primes

n=int(input(" "))
gen_prime=prime_numbers(n)
print(" ",gen_prime)

