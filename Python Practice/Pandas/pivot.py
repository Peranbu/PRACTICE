import pandas as pd
def pivotTable(weather: pd.DataFrame) -> pd.DataFrame:
  return weather.pivot(index='month',column='city',values='temperature')

"""
Example 1:
Input:
+--------------+----------+-------------+
| city         | month    | temperature |
+--------------+----------+-------------+
| Jacksonville | January  | 13          |
| Jacksonville | February | 23          |
| Jacksonville | March    | 38          |
| Jacksonville | April    | 5           |
| Jacksonville | May      | 34          |
| ElPaso       | January  | 20          |
| ElPaso       | February | 6           |
| ElPaso       | March    | 26          |
| ElPaso       | April    | 2           |
| ElPaso       | May      | 43          |
+--------------+----------+-------------+
Indes='city' column='month and temperature'

Output:
+----------+--------+--------------+
| month    | ElPaso | Jacksonville |
+----------+--------+--------------+
| April    | 2      | 5            |
| February | 6      | 23           |
| January  | 20     | 13           |
| March    | 26     | 38           |
| May      | 43     | 34           |
+----------+--------+--------------+

weather.pivot(index='month',column='city',value='temperature')

EXPLANATION


              C O L U M N
            _ _ _ _ _ _ _ _ _
           |
    I      |
    N      |
    D      |
    E      |
    X      |



    
