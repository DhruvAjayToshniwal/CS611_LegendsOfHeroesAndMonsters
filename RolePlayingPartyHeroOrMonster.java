public class RolePlayingPartyHeroOrMonster {
    private final int defaultPartyLocationX = 0;
    private final int defaultPartyLocationY = 0;
    private Hero[] playerParty;
    private int xLocation;
    private int yLocation;

    //initialise number of players and default location at start of map
    public RolePlayingPartyHeroOrMonster(int num) {
        playerParty = new Hero[num];
        xLocation = defaultPartyLocationX;
        yLocation = defaultPartyLocationY;
    }

    //method to get hero at location
    public Hero getPosition(int position) {
        return playerParty[position];
    }

    //set hero at location
    public void setPosition(int position, Hero hero) {
        playerParty[position] = hero;
    }

    //print inventory
    public void printTeamInv() {
        for (int i = 0; i < playerParty.length; i++)
            playerParty[i].printInventory();
    }

    //revive the dead members after the battle
    public void reviveTeam() {
        for (int i = 0; i < playerParty.length; i++) {
            if (playerParty[i].isDead())  //revive if dead
                playerParty[i].setHp(playerParty[i].getLvl() * 100 / 2);
        }
    }

    //if hero wins, HP, mana and level increases
    public void winBattle(int numberOfHeroes) {
        for (int i = 0; i < playerParty.length; i++) {
            //if a hero is not dead it gains money and xp and hp and mana
            if (!(playerParty[i].isDead())) {
                int money = playerParty[i].getMoney();
                playerParty[i].setExp(numberOfHeroes * 2);
                playerParty[i].setMoney(money + (getHighestLvl() * 100));
                playerParty[i].setHp((int) (playerParty[i].getHp() * 1.1));
                playerParty[i].setMana((int) (playerParty[i].getMana() * 1.1));
            }
        }
    }

    //check level up for every hero
    public void chkLevelUp() {
        for (int i = 0; i < playerParty.length; i++) {
            if (playerParty[i].checkifLevelUp())
                playerParty[i].levelUp();
        }
    }

    //print player party
    @Override
    public String toString() {
        String addChar = "";
        addChar += "\n";
        addChar += "Your party currently consists of \n";
        for (int i = 0; i < playerParty.length; i++) {
            addChar += playerParty[i] + "\n";
            addChar += "\n";
        }
        return addChar;
    }

    //check if all player dead then game over
    public boolean allDead() {
        int count = 0;
        for (int i = 0; i < playerParty.length; i++) {
            if (playerParty[i].isDead())
                count++;
        }
        if (count == playerParty.length)
            return true;
        return false;
    }

    //check number of heroes alive
    public int numOfHeroesAlive() {
        int count = 0;
        for (int i = 0; i < playerParty.length; i++) {
            if (!(playerParty[i].isDead())) {
                count++;
            }
        }
        return count;
    }

    //position of hero which are still alive after each round
    //these heroes are used for consecutive rounds until dead
    public int[] aliveHeroes() {
        int[] alive = new int[numOfHeroesAlive()];
        int count = 0;
        for (int i = 0; i < playerParty.length; i++) {
            if (!(playerParty[i].isDead())) {
                alive[count] = i;
                count++;
            }
        }
        return alive;
    }

    //get the highest level in the party
    public int getHighestLvl() {
        int highestLvl = 0;
        for (int i = 0; i < playerParty.length; i++) {
            if (playerParty[i].getLvl() > highestLvl) {
                highestLvl = playerParty[i].getLvl();
            }
        }
        return highestLvl;
    }

    //set the party's new position
    public void setLocation(int x, int y) {
        xLocation = x;
        yLocation = y;
    }

    //get length of the party
    public int getSize() {
        return playerParty.length;
    }

    public int getyLocation() {
        return yLocation;
    }

    public int getxLocation() {
        return xLocation;
    }
}