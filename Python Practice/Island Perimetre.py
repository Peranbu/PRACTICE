def IslandPerimetre(grid):
  island=0
  neighbours=0
  m=len(grid)
  n=len(grid[0])
  for i in range(m):
    for j in range(n):
      if grid[i][j]==1:
        island+=1
        if i+1<m and grid[i+1][j]==1:
          neighbours+=1
        if j+1<n and grid[i][j+1]==1:
          neighbours+=1
  return island*4 - neighbours*2


"""
island(box) contains 4 sides 
neighbours= two islands connected 
if two squares are connected it has 6 sides not 8 sides
example diagram is uploaded in photo
"""

