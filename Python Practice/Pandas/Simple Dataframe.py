#Leetcode
import pandas as pd
def createDataframe(Student_data:List[List[int]]) ->pd.DataFrame:
  df=pd.DataFrame(Student_data,columns=['student_age','id'])
  return df

###############
import pandas as pd
from typing import List
def CreateDataFrame(Student_data:List[List{int]]):  # input=list (List of integer) 
  #inner list contains two integers: the student ID and the student's age.
  df=pd.DataFrame(Student_data,columns=['Student_id','age'])
  return df

Student_data=[
  [1,12],
  [2,13],
  [3,14],
  [4,15]
]
df=CreateDataFrame(Student_data)
print(df.to_string(index=False)) #Convert it into String 


'''
only print -- Output
<bound method DataFrame.to_string of    Student_age  id
0            1  12
1            2  14
2            3  16
3            4  18>

print(df.to_string(index=True) -- Output
   Student_age  id
0            1  12
1            2  14
2            3  16
3            4  18

print(df.to_string(index=False)) -- Output
       Student_age  id
           1  12
           2  14
           3  16
           4  18   
'''

