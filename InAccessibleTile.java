public class InAccessibleTile extends LegTile {
    private final String InAccessibleSymbol = ANSI_RED_BACKGROUND + ANSI_BLACK + " N " + ANSI_RESET;

    //set the wall tiles symbol to N, so it stands for 'N'ot accessible
    public InAccessibleTile() {
        super();
        isAccessible = false;
        tileSymbol = InAccessibleSymbol;
    }

    //shift inaccessible symbol on update location
    public void shiftInAccessibleSymbol() {
        tileSymbol = InAccessibleSymbol;
    }
}