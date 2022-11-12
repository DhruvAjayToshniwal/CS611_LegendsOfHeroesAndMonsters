public class RolePlayingGameItems {
    protected String name;
    protected int cost;
    protected int rqLvl; //required level

    public RolePlayingGameItems() {
        name = "";
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getRqLvl() {
        return rqLvl;
    }
}