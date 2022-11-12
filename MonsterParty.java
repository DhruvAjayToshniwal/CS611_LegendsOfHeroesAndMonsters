public class MonsterParty {
    private Monster[] monsters;

    //create monster party of said size
    public MonsterParty(int num) {
        monsters = new Monster[num];
    }

    //to print all living monsters
    @Override
    public String toString() {
        String addChar = "";
        addChar += "\n";
        addChar += "Monsters that are alive: \n";
        for (int i = 0; i < monsters.length; i++) {
            //monster is alive
            if (monsters[i].getHp() > 0) {
                addChar += monsters[i] + "\n";
                addChar += "\n";
            }
        }
        return addChar;
    }

    //return true if every monster is dead
    public boolean allDead() {
        int count = 0;
        for (int i = 0; i < monsters.length; i++) {
            if (monsters[i].isDead()) {
                count++;
            }
        }
        if (count == monsters.length) {
            return true;
        }
        return false;
    }

    //position of monsters which are still alive after each round
    //these monsters are used for consecutive rounds until dead
    public int[] aliveMonsters() {
        int count = 0, alive[];
        for (int i = 0; i < monsters.length; i++) {
            if (!(monsters[i].isDead())) {
                count++;
            }
        }
        alive = new int[count];
        count = 0;
        for (int i = 0; i < monsters.length; i++) {
            if (!(monsters[i].isDead())) {
                alive[count] = i;
                count++;
            }
        }
        return alive;
    }

    //get length of monster party
    public int getLength() {
        return monsters.length;
    }

    //get a monster from party position
    public Monster getPosition(int position) {
        return monsters[position];
    }

    //set a monster at party position
    public void setPosition(int position, Monster mon) {
        monsters[position] = mon;
    }
}