import pandas as pd
def getDataframeSize(players: pd.DataFrame) -> List[int]: #the output should be in list of int
    row,col=players.shape  #shape is used to find rows and column
    return[row,col]
  
