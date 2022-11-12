public class Creature {
    protected int lvl;
    protected int HP;
    protected String name;
    protected int enemy;

    public Creature(HeroTypes Heroes) {
        name = Heroes.toString();
        lvl = 1;    //every creature hero or monster begins at level 1
        HP = 100;   //every creature hero or monster has HP 100 at level 1
    }

    public Creature() {
        if (!(this.getName() == null)) {
            if (!this.getName().equalsIgnoreCase("default"))
                name = this.getName();  //if creature is not hero
            else
                name = "default";   //if creature is hero
        }
        lvl = 1;    //every creature hero or monster begins at level 1
        HP = 100;   //every creature hero or monster has HP 100 at level 1
    }

    public void takeDamage(int dmg) {
        HP -= dmg;
    }

    public int getEnemy() {
        return enemy;
    }

    public void setEnemy(int enemy) {
        this.enemy = enemy;
    }

    public int getLvl() {
        return lvl;
    }

    public int getHp() {
        return HP;
    }

    public String getName() {
        return name;
    }

    public void setHp(int HP) {
        this.HP = HP;
    }
}