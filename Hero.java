import java.util.ArrayList;

public class Hero extends Creature {
    protected int strength;
    protected int dexterity;
    protected int agility;
    protected int mana;
    protected int experience;
    protected int money;
    protected ArrayList<Weapon> weapons;
    protected ArrayList<Armor> armor;
    protected ArrayList<Potion> potions;
    protected ArrayList<Spell> spells;
    protected Weapon equippedWeapon;
    protected Armor equippedArmor;

    public Hero(HeroTypes Heroes) {
        super(Heroes);
    }

    //Hero is dead if HP is 0 or below 0
    public boolean isDead() {
        if (this.HP <= 0) {
            return true;
        }
        return false;
    }

    //print inventory of hero
    public void printInventory() {
        System.out.println("---------------------------------");
        System.out.println(name + "'s inventory is listed below\n");
        System.out.println("Weapons");
        int count = 1;
        if (weapons.size() > 0) {
            for (Weapon w : weapons) {
                System.out.println(count + ". " + w);
                count++;
            }
            count = 0;
        }
        System.out.println("Armour");
        if (armor.size() > 0) {
            for (Armor a : armor) {
                System.out.println(count + ". " + a);
                count++;
            }
            count = 0;
        }
        System.out.println("Potions");
        if (potions.size() > 0) {
            for (Potion p : potions) {
                System.out.println(count + ". " + p);
                count++;
            }
            count = 0;
        }
        System.out.println("Spells");
        if (spells.size() > 0) {
            for (Spell s : spells) {
                System.out.println(count + ". " + s);
                count++;
            }
        }
        System.out.println("---------------------------------");
    }

    //method to set attributes of the hero
    public void setAttributes(String input) {
        lvl = 1;
        HP = lvl * 100;
        String[] attribute = input.split("\\s+");
        name = attribute[0];
        mana = Integer.parseInt(attribute[1]);
        strength = Integer.parseInt(attribute[2]);
        agility = Integer.parseInt(attribute[3]);
        dexterity = Integer.parseInt(attribute[4]);
        money = Integer.parseInt(attribute[5]);
        experience = Integer.parseInt(attribute[6]);
        weapons = new ArrayList<Weapon>();
        armor = new ArrayList<Armor>();
        potions = new ArrayList<Potion>();
        spells = new ArrayList<Spell>();
        equippedWeapon = new Weapon();
        equippedArmor = new Armor();
    }

    //equip armour
    public void equipArmor(int armourPosition) {
        equippedArmor = armor.get(armourPosition);
        System.out.println("Equipped armor = " + equippedArmor.getName());
    }

    //equip weapon to hero
    public void equipWeapon(int weaponPosition) {
        equippedWeapon = weapons.get(weaponPosition);
        System.out.println("Equipped weapon = " + equippedWeapon.getName());
    }

    //method to use potion once
    public void usePotion(int potionPosition) {
        potions.get(potionPosition).usePotion(this);
        System.out.println("Potion used = " + potions.get(potionPosition).getName());
        potions.remove(potionPosition);
    }

    //method to use spell
    //mana required to use spell
    public boolean useSpell(int spellIndex) {
        //if the player has enough mana, then subtract it from the mana
        int manaCost = spells.get(spellIndex).getManaCost();
        if (this.mana >= manaCost) {
            this.mana = this.mana - manaCost;
            return true;
        }
        System.out.println("Hero does not have enough mana to use the spell!\nMana needed = " + manaCost + "\nMana present = " + this.mana);
        return false;
    }

    //method to print hero stats
    @Override
    public String toString() {
        String joinData = "";
        String tab = "\t";
        if (isDead())
            joinData += "DEAD ";
        joinData += this.name + tab;
        joinData += "LV: " + this.lvl + tab;
        joinData += "HP: " + this.HP + tab;
        joinData += "Mana:" + this.mana + tab;
        joinData += "Str: " + this.strength + tab;
        joinData += "Agl: " + this.agility + tab;
        joinData += "Dex: " + this.dexterity + tab;
        joinData += "Money: " + this.money + tab;
        joinData += "Exp: " + this.experience + tab;
        joinData += "Wpn: " + this.equippedWeapon.getName() + tab;
        joinData += "Armor: " + this.equippedArmor.getName() + tab;
        return joinData;
    }

    //check if a hero has leveled up
    public boolean checkifLevelUp() {
        if (experience >= lvl * 10) {
            return true;
        }
        return false;
    }

    //update hero stats
    public void levelUp() {
        lvl++;
        HP = lvl * 100;
        mana = (int) (mana * 1.1);
        strength = (int) (strength * 1.05);
        agility = (int) (agility * 1.05);
        dexterity = (int) (dexterity * 1.05);
    }

    //method to calculate the amount of damage a hero does with a weapon
    public int calcWpDmg() {
        return (int) ((strength + equippedWeapon.getDmg()) * .05);
    }

    //method to calculate the dodge chance of the hero
    public int calcDodge() {
        return (int) ((agility) * .002);
    }

    //hero takes damage on armour and HP
    public void takeDamage(int dmg) {
        this.HP = this.HP - (dmg - (equippedArmor.getDamageReductionValue() / 10));
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public int getMana() {
        return mana;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<Armor> getArmor() {
        return armor;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setExp(int experience) {
        this.experience = experience;
    }

    public int getMoney() {
        return this.money;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}