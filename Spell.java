public class Spell extends RolePlayingGameItems {
    private int dmg;
    private int manaCost;
    private Spells spellType;

    public Spell() {
        super();
    }

    //method to setAttributes for spell
    public void setAttributes(String input, Spells spellType) {
        String[] attribute = input.split("\\s+");
        this.name = attribute[0];
        this.cost = Integer.parseInt(attribute[1]);
        this.rqLvl = Integer.parseInt(attribute[2]);
        this.dmg = Integer.parseInt(attribute[3]);
        this.manaCost = Integer.parseInt(attribute[4]);
        this.spellType = spellType;
    }

    //print spells and info
    @Override
    public String toString() {
        String addChar = "";
        String tab = "  ";
        addChar += this.name + tab;
        addChar += "Cost: " + this.cost + tab;
        addChar += "rqLVL: " + this.rqLvl + tab;
        addChar += "Damage: " + this.dmg + tab;
        addChar += "ManaCost: " + this.manaCost + tab;
        return addChar;
    }

    public int getDmg() {
        return dmg;
    }

    public Spells getSpellType() {
        return spellType;
    }

    public int getManaCost() {
        return manaCost;
    }
}