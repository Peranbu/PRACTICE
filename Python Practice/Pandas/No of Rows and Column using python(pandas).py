#Answer 1 
import pandas as pd
def getDataframeSize(players: pd.DataFrame) -> List[int]: #the output should be in list of int
    row,col=players.shape  #shape is used to find rows and column
    return[row,col]


#Answer 2
import pandas as pd
def getDataframeSize(players):
    """
    :param players: pandas DataFrame
    :return: list of two integers representing the number of rows and columns
    """
    row,col=players.shape
    return [row,col]
