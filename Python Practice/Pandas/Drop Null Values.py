import pandas as pd
def DropNull(students:pd.DataFrame) -> pd.DataFrame:
  return students.dropna(subset=['name'])

"""
dropna used to drop null elements
"""

