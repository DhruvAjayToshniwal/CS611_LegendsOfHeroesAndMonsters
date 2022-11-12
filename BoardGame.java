public class BoardGame {
    public Board board;
    public boolean isGameOver;

    //options to move on board
    public final String quit = "Q";
    public final String showInventory = "E";
    public final String showMap = "M";
    public final String goUp = "W";
    public final String goDown = "S";
    public final String goRight = "D";
    public final String Info = "I";
    public final String goLeft = "A";

    public BoardGame() {
        board = new Board();
        isGameOver = false;
    }
}