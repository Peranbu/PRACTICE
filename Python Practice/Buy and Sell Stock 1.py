def Stock(price):
  buy=price[0]
  profit=0
  for i in range(1,len(nums)):
    if price[i]<buy:
      buy=price[i]
    elif price[i]-buy>profit:
      profit=price[i]-buy
  return profit

price=list(map(int,input(",").split(",")))
print(" ",Stock(price))

"""
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
"""

