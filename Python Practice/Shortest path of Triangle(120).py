def Shortest(Triangle):
  def dfs(i,j):
    if i==len(Triangle):
      return 0
    lower_left=Triangle[i][j]+dfs(i+1,j)
    lower_right=Triangle[i][j]+dfs(i+1,j+1)
    return min(lower_left,lower_right)
  return dfs(0,0)

