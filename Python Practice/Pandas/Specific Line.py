import pandas as pd
def SpecificLine(Students:pd.DataFrame) ->pd.DataFrame:
  return Students[Students['Student_id']==101][['Student_id','age']]


'''
 The double square brackets [[...]] are used to pass a list of column names to select these columns
'''
