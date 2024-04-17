import pandas as pd
def changeDatatype(students: pd.DataFrame) -> pd.DataFrame:
  students['grade']=students['grade'].astype(int)    #astype used to convert
  return students
  
