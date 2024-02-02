import heapq
array=[11,23,21,45,43,67,65]
n=int(input("enter the nth value"))
if n<0 or n>len(array):
      print("invalid input")
else:
    nth_largest=heapq.nlargest(n,array)[-1]
    print("",nth_largest)
    nth_smallest=heapq.nsmallest(n,array)[-1]
    print("",nth_smallest)
