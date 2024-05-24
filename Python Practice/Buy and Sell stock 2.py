def stock(price):
  profit=0
  for i in range(1,len(price)):
    if price[i]>price[i-1]:
      profit=price[i]-price[i-1]
  return profit
  
price=list(map(int,input(" ").split(",")))
print(" ",stock(price))

"""
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
"""
