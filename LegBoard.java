import java.util.Random;

public class LegBoard extends Board {
    //default party location
    private final String PSymbol = ANSI_BLUE_BACKGROUND + ANSI_BLACK + " P " + ANSI_RESET;
    private final int PlayerPartyLocationX = 0;
    private final int PlayerPartyLocationY = 0;
    private int lastKnownX;
    private int lastKnownY;

    public LegBoard() {
        board = new LegTile[defaultBoardSize][defaultBoardSize];
        initialiseTilesOnBoard();
    }

    //updates the Party's position on the map
    public void updatePlayer(int x, int y) {
        //change back to the original symbol
        if (board[lastKnownX][lastKnownY] instanceof InAccessibleTile)
            ((InAccessibleTile) board[lastKnownX][lastKnownY]).shiftInAccessibleSymbol();
        if (board[lastKnownX][lastKnownY] instanceof AccessibleTile)
            ((AccessibleTile) board[lastKnownX][lastKnownY]).shiftAccessibleSymbol();
        else
            ((MarketTile) board[lastKnownX][lastKnownY]).shiftMarketSymbol();
        ((LegTile) board[x][y]).shiftPlayerSymbol(PSymbol);

        //update new location in lastKnownX of class variable
        lastKnownX = x;
        lastKnownY = y;
    }

    public void initialiseTilesOnBoard() {
        int totalTiles = defaultBoardSize * defaultBoardSize;

        //number of walls is around 20 percent
        int inAccessibletab = (int) (totalTiles * .2);

        //number of market tiles is about 30 percent
        int numMarket = (int) (totalTiles * .3);

        //accessible tiles = total - market - inaccessible
        int Commontab = totalTiles - numMarket - inAccessibletab;
        //We randomly set the tiles. As 50% of tiles are accessible, we select 2/4 for accessible and rest for inaccessible and market
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                //the party will always start on a blank tile
                if (x == PlayerPartyLocationX && y == PlayerPartyLocationY) { //will execute only once (first time to set party location at tile 0)
                    board[x][y] = new AccessibleTile();
                    Commontab--;
                }
                //as we go tile by tile, we set it as accessible, inaccessible or market tile
                else {
                    Random rand = new Random();
                    int tileNum = rand.nextInt(4) + 1;

                    if (tileNum == 1 && numMarket > 0) {
                        board[x][y] = new MarketTile();
                        numMarket--;
                    } else if (tileNum == 2 && inAccessibletab > 0) {
                        board[x][y] = new InAccessibleTile();
                        inAccessibletab--;
                    } else if ((tileNum == 4 || tileNum == 3) && Commontab > 0) {
                        board[x][y] = new AccessibleTile();
                        Commontab--;
                    } else if (inAccessibletab > 0) {
                        board[x][y] = new InAccessibleTile();
                        inAccessibletab--;
                    } else if (numMarket > 0) {
                        board[x][y] = new MarketTile();
                        numMarket--;
                    } else {
                        board[x][y] = new AccessibleTile();
                        Commontab--;
                    }
                }
            }
        }
        updatePlayer(PlayerPartyLocationX, PlayerPartyLocationY);
    }

    //check if the party is able to go to that tile
    public boolean canGo(int x, int y) {
        if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && ((LegTile) board[x][y]).isAccessible)
            return true;
        System.out.println("Hero Party cannot go to that tile");
        return false;
    }
}