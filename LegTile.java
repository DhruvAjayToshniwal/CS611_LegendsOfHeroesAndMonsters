public class LegTile extends Tile {
    protected String tileSymbol;
    public LegTile() {
        super();
        tileSymbol = "";
    }

    //gives Tile type with symbol
    @Override
    public String toString() {
        return tileSymbol;
    }

    public void shiftPlayerSymbol(String tileSymbol) {
        this.tileSymbol = tileSymbol;
    }
}