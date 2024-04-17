import pandas as pd
def RenameColumns(Students:pd.DataFrame) ->pd.DataFrame:
  Students.rename(columns={'id':'Student_id','first':'first_name':'last'='last_name},inplace=True)
  return Students
  
