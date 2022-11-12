public class Board {
    protected Tile[][] board;
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";

    protected final int defaultBoardSize = 8;

    public Board() {
        board = new Tile[defaultBoardSize][defaultBoardSize];
    }

    //method to get single tile
    public Tile getTile(int x, int y) {
        return board[x][y];
    }

    //override toString to print board
    @Override
    public String toString() {
        String addChar = "", row = "\n";
        for (int i = 0; i < board.length; i++) {
            addChar = addChar + row;
            for (int j = 0; j < board[0].length; j++) {
                addChar = addChar + "|";
                addChar = addChar + board[i][j].toString();
                if (j == board[0].length - 1) {
                    addChar += "|";
                }
            }
        }
        addChar = addChar + row;
        return addChar;
    }
}