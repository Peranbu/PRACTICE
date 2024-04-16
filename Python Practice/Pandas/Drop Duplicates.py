import pandas as pd
def Dropduplicates(employees:pd.DataFrame) ->pd.DataFrame:
  return employees.drop_duplicates(subset=['email'])

"""
employees(column name) 
drop.duplicates(to remove duplicate rows)
subset=['email'] from which column the duplicates should be removed
"""

