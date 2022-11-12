public class AccessibleTile extends LegTile {
    private final String accessibleSymbol = ANSI_WHITE_BACKGROUND + ANSI_BLACK + "   " + ANSI_RESET;

    //show accessible tile in white and with tab
    public AccessibleTile() {
        super();
        tileSymbol = accessibleSymbol;
    }

    //shift accessible symbol on update location
    public void shiftAccessibleSymbol() {
        tileSymbol = accessibleSymbol;
    }
}