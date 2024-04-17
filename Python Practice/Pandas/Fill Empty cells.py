import pandas as pd
def fillMissingValues(products: pd.DataFrame) -> pd.DataFrame:
  products['quantity'].fillna(value=0,inplace=True)  #FIllna is used to replace none as 0
  return products
  
