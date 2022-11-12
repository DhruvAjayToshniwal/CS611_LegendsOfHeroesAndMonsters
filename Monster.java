public class Monster extends Creature {
    protected int baseDamage;
    protected int defense;
    protected int dodge;

    public Monster() {
    }

    public boolean isDead() {
        //check if HP is 0 or negative which means dead
        if (this.HP <= 0) {
            return true;
        }
        return false;
    }

    //print monster stats
    @Override
    public String toString() {
        String addChar = "";
        String tab = "  ";
        addChar += getClass().getName() + tab;
        addChar += name + tab;
        addChar += "LVL: " + lvl + tab;
        addChar += "HP: " + HP + tab;
        addChar += "Damage: " + baseDamage + tab;
        addChar += "DEF: " + defense + tab;
        addChar += "DODGE: " + dodge + tab;
        return addChar;
    }

    //method to setAttributes for monster
    public void setAttributes(String input) {
        //split off of any white tab
        String[] attribute = input.split("\\s+");
        this.name = attribute[0];
        this.lvl = Integer.parseInt(attribute[1]);
        this.baseDamage = Integer.parseInt(attribute[2]);
        this.defense = Integer.parseInt(attribute[3]);
        this.dodge = Integer.parseInt(attribute[4]);
        //set HP
        this.HP = lvl * 100;
    }

    //Spells affects monsters stats differently according to spell type
    public void effectOfSpell(Spell spell) {
        //10% decreases for affected stat
        switch (spell.getSpellType()) {
            case Ice:
                this.baseDamage = this.baseDamage - (int) (this.baseDamage * .1);
                break;
            case Fire:
                this.defense = this.defense - (int) (this.defense * .1);
                break;
            case Lightning:
                this.dodge = this.dodge - (int) (this.dodge * .1);
                break;
        }
    }

    //method to match Monster level with Maximum Hero
    public void matchLevelOfHero(int newLvl) {
        int oldLvl = this.lvl;
        this.lvl = newLvl;
        this.baseDamage = baseDamage / oldLvl * newLvl;
        this.defense = defense / oldLvl * newLvl;
        this.HP = lvl * 100;
    }


    //method to calculate the amount of damage
    public int calcDmg() {
        return (int) (this.baseDamage * .15);
    }

    //method to calculate the dodge chance of the hero
    public int calcDodge() {
        return (int) (dodge * .01);
    }

    //take damage and subtract defense of monster from heroes attack
    public void takeDamage(int dmg) {
        this.HP = this.HP - (dmg - (defense / 100));
    }
}