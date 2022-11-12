public class Potion extends RolePlayingGameItems {
    private int increase; //attribute increase
    private String useOfPotion; //attribute affected

    public Potion() {
        super();
    }

    //method to setAttributes
    public void setAttributes(String input) {
        String[] attribute = input.split("\\s+");
        this.name = attribute[0];
        this.cost = Integer.parseInt(attribute[1]);
        this.rqLvl = Integer.parseInt(attribute[2]);
        this.increase = Integer.parseInt(attribute[3]);
        this.useOfPotion = attribute[4];
    }

    //print potion stats
    @Override
    public String toString() {
        String addChar = "";
        String tab = "\t";
        addChar += this.name + tab;
        addChar += "Cost = " + this.cost + tab;
        addChar += "rqLVL = " + this.rqLvl + tab;
        addChar += "Potency = " + this.increase + tab;
        addChar += "Affinities = " + this.useOfPotion + tab;
        return addChar;
    }

    //use a potion on the heroWithPotion
    public void usePotion(Hero heroWithPotion) {
        String[] attribute = useOfPotion.split("/");
        for (int i = 0; i < attribute.length; i++) {
            switch (attribute[i]) {
                case "Health":
                    heroWithPotion.setHp(heroWithPotion.getHp() + increase);
                    break;
                case "Strength":
                    heroWithPotion.setStrength(heroWithPotion.getStrength() + increase);
                    break;
                case "Mana":
                    heroWithPotion.setMana(heroWithPotion.getMana() + increase);
                    break;
                case "Dexterity":
                    heroWithPotion.setDexterity(heroWithPotion.getDexterity() + increase);
                    break;
                case "Agility":
                    heroWithPotion.setAgility(heroWithPotion.getAgility() + increase);
                    break;
                case "All":
                    heroWithPotion.setHp(heroWithPotion.getHp() + increase);
                    heroWithPotion.setMana(heroWithPotion.getMana() + increase);
                    heroWithPotion.setStrength(heroWithPotion.getStrength() + increase);
                    heroWithPotion.setDexterity(heroWithPotion.getDexterity() + increase);
                    heroWithPotion.setAgility(heroWithPotion.getAgility() + increase);
                    break;
            }
        }
    }
}