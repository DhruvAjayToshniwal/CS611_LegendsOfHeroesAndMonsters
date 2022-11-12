public class Tile {
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    protected boolean isAccessible;
    protected String contents;

    public Tile() {
        isAccessible = true;
        contents = "";
    }

    @Override
    public String toString() {
        return contents;
    }
}