public class Weapon extends RolePlayingGameItems {
    private int dmg;
    private int rqHands;

    public Weapon() {
        super();
        dmg = 0;
    }

    public void setAttributes(String input) {
        String[] attribute = input.split("\\s+");
        this.name = attribute[0];
        this.cost = Integer.parseInt(attribute[1]);
        this.rqLvl = Integer.parseInt(attribute[2]);
        this.dmg = Integer.parseInt(attribute[3]);
        this.rqHands = Integer.parseInt(attribute[4]);
    }

    //print weapon and info
    @Override
    public String toString() {
        String addChar = "";
        String tab = "  ";
        addChar += this.name + tab;
        addChar += "Cost: " + this.cost + tab;
        addChar += "rqLVL: " + this.rqLvl + tab;
        addChar += "Damage: " + this.dmg + tab;
        addChar += "rqHANDS: " + this.rqHands + tab;
        return addChar;
    }

    public int getDmg() {
        return dmg;
    }
}