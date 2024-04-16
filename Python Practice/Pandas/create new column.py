import pandas as pd
def NewColumn(employees:pd.DataFrame) ->pd.DataFrame:
  employees['Bonus']=2*employees.salary  
  return employees

"""
employees['bonus'] - to add new column to the table named employees
according to the requirement change it
"""


