import pandas as pd
def modifySalaryColumn(employees:pd.DataFrame) ->pd.DataFrame:
  employees.salary*=2
  return employees

"""
employees.salary*=2
condition to multiply the salary by 2
"""


