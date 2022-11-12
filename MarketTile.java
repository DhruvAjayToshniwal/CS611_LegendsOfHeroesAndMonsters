public class MarketTile extends LegTile {
    private final String DEFAULT_ICON = ANSI_GREEN_BACKGROUND + ANSI_BLACK + " M " + ANSI_RESET;

    //set the tileSymbol to M for market
    public MarketTile() {
        super();
        tileSymbol = DEFAULT_ICON;
    }

    //shift market symbol on update location
    public void shiftMarketSymbol() {
        tileSymbol = DEFAULT_ICON;
    }
}