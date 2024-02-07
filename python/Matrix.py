#def,initialize,for,row,append,return
def matrix_cal(rows,cols):
  matrix=[]
  for x in range(rows):
    row=[float(num) for num in input(" ").split(',')]
    matrix.append(row)
  return matrix
#def,initialize,for,row,append,print
#add=sum
def mat_add(matrix_a,matrix_b):
  result=[]
  for i in range(len(matrix_a)):
    row=[sum(x) for x in zip(matrix_a[i],matrix_b[i])]
    result.append(row)
  return result
  #sub=x-y
def mat_sub(matrix_a,matrix_b):
  result=[]
  for i in range(len(matrix_a)):
    row=[x-y for x,y in zip(matrix_a[i],matrix_b[i])]
    result.append(row)
  return result  
#mul=sum[(a*b for a,b in zip(matrix_a[i],col)) for col in zip(*matrix_b)]
def mat_mul(matrix_a,matrix_b):
  result=[]
  for i in range(len(matrix_a)):
    row=[sum(a*b for a,b in zip(matrix_a[i],cols)) for cols in zip(*matrix_b)]
    result.append(row)
  return result
#div=a/b
def mat_div(matrix_a,matrix_b):
  result=[]
  for i in range(len(matrix_a)):
    row=[a/b for a,b in zip(matrix_a[i],matrix_b[i])]
    result.append(row)
  return result
rows=int(input(" "))
cols=int(input(" "))
Matrix_a=matrix_cal(rows,cols)
Matrix_b=matrix_cal(rows,cols)
result_add=mat_add(Matrix_a,Matrix_b)
for row in result_add:
  print(row)
result_sub=mat_sub(Matrix_a,Matrix_b)
for row in result_sub:
  print(row)
result_mul=mat_mul(Matrix_a,Matrix_b)
for row in result_mul:
  print(row)
result_div=mat_div(Matrix_a,Matrix_b)
for row in result_div:
  print(row)
