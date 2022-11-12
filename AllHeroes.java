public class AllHeroes extends Hero {
    //default constructor calls to Super to set hero type from enum HeroTypes
    AllHeroes(HeroTypes Heroes) {
        super(Heroes);
    }

    //method for level up according to hero Type
    public void levelUp() {
        if (this.getName().equalsIgnoreCase("Sorcerer")) {
            lvl++;
            HP = lvl * 100;
            mana = (int) (mana * 1.1);
            strength = (int) (strength * 1.05);
            agility = (int) (agility * 1.10);
            dexterity = (int) (dexterity * 1.10);
        }
        if (this.getName().equalsIgnoreCase("Paladin")) {
            lvl++;
            HP = lvl * 100;
            mana = (int) (mana * 1.1);
            strength = (int) (strength * 1.10);
            agility = (int) (agility * 1.05);
            dexterity = (int) (dexterity * 1.10);
        }
        if (this.getName().equalsIgnoreCase("Warrior")) {
            lvl++;
            HP = lvl * 100;
            mana = (int) (mana * 1.1);
            strength = (int) (strength * 1.10);
            agility = (int) (agility * 1.10);
            dexterity = (int) (dexterity * 1.05);
        }
    }
}