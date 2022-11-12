public class Armor extends RolePlayingGameItems {
    private int damageReductionValue;

    public Armor() {
        super();
        damageReductionValue = 0;
    }

    //print weapon stats
    @Override
    public String toString() {
        String addChar = "";
        String tab = "\t";
        addChar += this.name + tab;
        addChar += "Cost = " + this.cost + tab;
        addChar += "rqLVL = " + this.rqLvl + tab;
        addChar += "damageReductionValue = " + this.damageReductionValue + tab;
        return addChar;
    }

    //method to setAttributes
    public void setAttributes(String input) {
        String[] attribute = input.split("\\s+");
        this.name = attribute[0];
        this.cost = Integer.parseInt(attribute[1]);
        this.rqLvl = Integer.parseInt(attribute[2]);
        this.damageReductionValue = Integer.parseInt(attribute[3]);
    }

    public int getDamageReductionValue() {
        return damageReductionValue;
    }
}