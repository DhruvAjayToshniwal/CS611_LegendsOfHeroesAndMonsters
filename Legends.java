import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Legends extends BoardGame {

    private int moveStats;
    private int numberOfHeroes;
    private int healthLoss;
    private int moneySpent;
    private int numberOfWins;
    private int numberOfLosses;
    private int numberOfMarketsVisited;
    private LegBoard board;
    private final DataPool data;
    private RolePlayingPartyHeroOrMonster playerParty;
    private Scanner myScanner;
    Random rand;
    private final int rollADie = 2; //Chance to meet monsters in battle

    public Legends() {
        myScanner = new Scanner(System.in);
        data = new DataPool();
        rand = new Random();
        moveStats = 0;
        healthLoss = 0;
        moneySpent = 0;
        numberOfWins = 0;
        numberOfMarketsVisited = 0;
        numberOfHeroes = 0;
        numberOfLosses = 0;
    }

    //calls all functionalities of game
    public void playGame() throws InterruptedException {
        System.out.println("\t\t\t\tWelcome to the World of Legends: Monsters v/s Heroes!");
        String printArt1 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠊⠁⠀⠀⠉⢳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⠀⠀⠀⠀⠀⢢⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢱⢶⠆⠛⠁⠀⠸⢊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠨⠔⠀⠀⠔⢠⣏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣣⠙⠁⠀⢀⡆⢻⡶⡤⣄⣠⣤⣀⡀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⡠⠾⠙⣳⡶⠚⢹⠣⢀⢵⠾⢟⠉⠁⠓⠽⢷⡀⠀⠀\n" +
                "⠀⠀⠀⠀⢀⠤⠒⠓⠲⠶⡄⠈⠐⠒⠺⢶⣿⣗⠤⠀⢰⠀⠀⠀⠀⣧⠀⠀\n" +
                "⠀⠀⠀⢀⠃⠀⠀⠀⠀⠀⡃⠀⠀⠀⠐⠙⢻⡄⠀⠀⠘⣦⣄⠀⠐⠛⢆⠀\n" +
                "⠀⠀⢀⣌⠀⠀⠀⠀⠀⣼⠁⠀⠀⠀⠀⠒⠒⣿⠉⠀⠀⣿⢠⠀⠀⠀⠙⡆\n" +
                "⠀⡰⠋⠀⢀⠀⠈⠉⢻⣿⣦⡄⡀⠀⠀⠀⠴⣾⣏⣁⣠⣿⡈⣣⠀⢀⣇⢰\n" +
                "⠀⣇⡔⠀⠀⡇⣀⣀⣾⠃⠈⠛⠶⠶⣴⠶⠋⠁⢄⠈⠙⣿⡟⠁⠀⠀⠘⢈\n" +
                "⢰⡟⠀⠀⠐⢿⠻⣿⣯⡓⠂⠀⠀⠀⢸⠀⠀⠀⢘⣆⡠⠟⠓⠂⠀⢀⡠⠜\n" +
                "⢸⡟⣖⠀⠀⠀⠑⡘⢿⣿⡆⠀⢀⠤⠤⠤⣤⡤⠞⠉⠀⠀⣀⠠⡶⠋⠀⠀\n" +
                "⠀⠙⠮⣢⡤⣀⠀⠐⠠⣹⡇⢀⣋⡌⢀⡀⠀⠀⣀⣄⣀⠥⠐⠊⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠈⠉⠓⠧⣤⣄⠀⠉⠁⠐⢌⡹⣿⡶⠾⡟⠁⣿⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣆⡀⠀⠤⢰⢿⡄⠀⠁⠀⡿⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢰⠟⠉⠉⠛⣶⣶⣷⠈⠺⠆⠀⢠⣧⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠘⠛⠛⠓⠀⠀⠀⠈⠙⠂⠀⠀⠀⠀⠀⠀", printArt2 = "⡿⠉⣉⡁⠈⠁⢀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠇⢉⣿⢇⣀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠏⠉⠻⣯⠍⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣮⣿⣶⣤⢀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠋⠀⠉⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠀⢀⠴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠠⣼⣥⣴⣾⠟⣻⣿⢿⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⠀⠀⠀⠀⠉⢻⣿⣿⣄⡛⠛⣨⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣄⡀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⡟⠟⠟⣦⠙⣇⣀⡄⠀⠀⠀⠈⠛⠿⠿⠿⠿⢿⠟⠛⠀⢀⡀⠀⠀⠀⠀⣴⣾⡟⢛⣿⣿⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⡇⠘⢀⣩⣆⣼⠉⢿⣄⠀⣀⣀⡀⢀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡟⠉⣲⡄⡿⣿⣧⣌⣋⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣧⢠⣾⣉⣛⢸⠀⢦⣿⣿⣿⣉⣉⡀⠀⠀⠀⠀⠀⠀⠐⢻⠟⠃⢠⣿⠇⠀⠈⠛⠛⠛⠋⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣧⣙⠺⠙⣿⡄⠀⠘⡍⢻⣿⣿⣷⣶⣶⣤⣤⣤⣀⣀⠘⠂⠀⠈⠃⠀⠀⠀⠀⢀⠀⠀⡘⠻⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣿⡇⠀⠀⠁⠈⣿⣿⣿⣿⣿⣿⡿⡿⡿⣿⣿⣿⣶⣤⣤⣤⣄⣀⠀⢀⣷⣾⠖⠉⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢷⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣾⣿⣿⣥⣿⣏⣿⣻⠻⣿⣿⣿⡿⣿⡟⠰⢠⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠘⣧⠀⠂⢀⠀⠈⠉⢿⣿⣥⣏⡿⣿⣿⣿⣿⣿⣿⣷⣶⣿⣿⠛⢡⠟⢁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⢀⢻⣧⠀⡌⠀⠀⠀⠀⢻⣿⣿⣷⣯⣹⡟⣝⣛⣯⣽⣿⡟⠁⢠⣯⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⢸⢿⣿⣧⣼⣷⠀⠀⠀⠀⡙⠻⣿⣿⣿⣿⣿⣿⣿⠟⠋⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⡟⠀⠘⡃⢹⣿⣿⣮⣧⠀⠀⠀⠈⠁⠉⠌⣉⣙⡻⠋⠁⡀⣀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠛⠛⠛⠛⠋⠉⠉⠉⠀⢠⡞⠀⠀⢀⡇⠘⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠇⢠⠀⢨⡇⠀⠋⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⣠⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠸⡅⠀⠀⠘⠿⣿⣿⣿⣿⣷⣶⣶⣤⣤⣤⣴⢋⢺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠉⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⡜⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠀⢀⠀⠀⠀⠀⠀⢳⣶⣾⣿⣿⣿⣿⣿⡏⠀⠀⡰⠁⠀⠈⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡀⣶⣽⣿⣿⣿⣿⡟⡍⡀⠀⠀⠁⠀⠀⠀⠀⠀⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿";
        System.out.println(printArt1 + "\n\n\n\n\n" + printArt2);
        //creating map and board with 8 x 8 tiles
        //If user wants another map, provide!

        while (true) {
            board = new LegBoard();
            System.out.println("Building the Board...");
            delay();
            System.out.println(board);
            System.out.println("Do you want another board?\n1. for Y\n2. for N");
            if (validateIntInput(1, 2) == 2)
                break;
        }

        //set playerParty and ask to choose heroes
        chooseHeroes();
        System.out.println(playerParty);
        System.out.println("!! LET THE GAMES BEGIN !!");

        System.out.println(board);
        while (!isGameOver)
            playerTurn();
        System.out.println("Thank you for playing!\nHere are your statistics for the game\n\n");
        Statistics();
    }

    //method for a player's turn that shows them their current options
    public void playerTurn() throws InterruptedException {
        Tile currTile = board.getTile(playerParty.getxLocation(), playerParty.getyLocation());
        if (currTile instanceof MarketTile) //check if tile is market
            Market();
        System.out.println("--------------------------------------------------");
        System.out.println("Enter " + goUp + " to move up.");
        System.out.println("Enter " + goLeft + " to move left.");
        System.out.println("Enter " + goDown + " to move down.");
        System.out.println("Enter " + goRight + " to move right.");
        System.out.println("Enter " + Info + " to see Hero Info");
        System.out.println("Enter " + quit + " to quit.");
        System.out.println("Enter " + showInventory + " to manage inventory.");
        System.out.println("Enter " + showMap + " to show the Map");
        System.out.println("--------------------------------------------------");
        canPartyWalk();
    }

    //check if tile is walkable and then move party to new location
    public void canPartyWalk() {
        String option = validateCharInput();
        int currX = playerParty.getxLocation();
        int currY = playerParty.getyLocation();
        //check menu and compare with choice
        switch (option) {
            case goUp:
                if (board.canGo(currX - 1, currY)) {
                    moveParty(currX - 1, currY);
                    moveStats++;
                } else
                    canPartyWalk();
                break;
            case goLeft:
                if (board.canGo(currX, currY - 1)) {
                    moveParty(currX, currY - 1);
                    moveStats++;
                } else
                    canPartyWalk();
                break;
            case goDown:
                if (board.canGo(currX + 1, currY)) {
                    moveParty(currX + 1, currY);
                    moveStats++;
                } else
                    canPartyWalk();
                break;
            case goRight:
                if (board.canGo(currX, currY + 1)) {
                    moveParty(currX, currY + 1);
                    moveStats++;
                } else
                    canPartyWalk();
                break;
            case Info:
                System.out.println(playerParty);
                break;
            case quit:
                isGameOver = true;
                break;
            case showMap:
                System.out.println(board);
                break;
            case showInventory:
                manageInv();
                break;
        }
    }

    //method to update player location
    public void moveParty(int x, int y) {
        playerParty.setLocation(x, y);
        board.updatePlayer(x, y);
        System.out.println(board);
        if (board.getTile(x, y) instanceof AccessibleTile) {    //checking for battle everytime Party moves to accessible tile
            ifBattle(x, y);
        }
    }

    //method to choose heroes
    public void chooseHeroes() throws InterruptedException {
        System.out.println("Please enter the number of heroes for your party!");
        System.out.println("Max number of heroes you can have is 3");
        numberOfHeroes = validateIntInput(1, 3);
        playerParty = new RolePlayingPartyHeroOrMonster(numberOfHeroes);
        //add a hero for the amount of times the player chose
        for (int i = 0; i < numberOfHeroes; i++) {
            System.out.println("What hero would you like?");
            System.out.println("1. for Warrior\n2. for Sorcerer\n3. for Paladin");
            int choice = validateIntInput(1, 3);    //get choice of hero
            System.out.println("Checking the database...");
            delay();
            String heroString = data.chooseHeroes(choice, true);
            System.out.println("Your hero is:");
            System.out.println(heroString);
            //now generate the object with the hero factory and add it to the party
            CreatureFactory createHero = new CreatureFactory();
            Hero nHero = createHero.createHero(choice);
            nHero.setAttributes(heroString);
            playerParty.setPosition(i, nHero);
        }
    }

    //allow the player to use a hero's inventory
    public void manageInv() {
        playerParty.printTeamInv();
        System.out.println("Which hero's inventory do you want to manage?");
        for (int i = 1; i <= playerParty.getSize(); i++) {
            System.out.println(i + ". " + playerParty.getPosition(i - 1));
        }
        int choice = validateIntInput(0, playerParty.getSize());
        Hero hero = playerParty.getPosition(choice - 1);
        System.out.println("Hero selected = " + hero.getName());
        hero.printInventory();
        System.out.println("Please enter your choice");
        System.out.println("0. to Exit");
        System.out.println("1. Equip Items");
        System.out.println("2. Use Potion");
        choice = validateIntInput(0, 2);
        //get input and then do a method based on the choice
        if (choice == 1)
            equipItem(hero);
        else if (choice == 2)
            usePotion(hero);
    }

    //select the hero and choose whether they want to shop or sell
    public void Market() throws InterruptedException {
        System.out.println("------------------------------------");
        System.out.println("You are near a market");
        System.out.println("What would you like to do?");
        System.out.println("1. Enter the market");
        System.out.println("2. Continue\n");
        int choice = validateIntInput(1, 2);
        if (choice == 2)
            return;
        System.out.println("Entering the market world...");
        delay();
        System.out.println("Welcome to the market!");
        numberOfMarketsVisited++;

        System.out.println("Please select a hero you want to customize!");
        for (int i = 0; i < playerParty.getSize(); i++)
            System.out.println(i + 1 + ". " + playerParty.getPosition(i));
        //get the player's choice and set the hero
        choice = validateIntInput(0, playerParty.getSize());
        if (choice > 0) {
            Hero hero = playerParty.getPosition(choice - 1);
            hero.printInventory();
            System.out.println("What would you like to do?");
            System.out.println("0. Exit");
            System.out.println("1. Shop");
            System.out.println("2. Sell");
            int choice2 = validateIntInput(0, 2);
            if (choice2 == 1)
                buyItem(hero);
            else if (choice2 == 2)
                sellItem(hero);
        }
    }

    //allow the hero to buy items
    //for simplicity allow them to buy any item in the files
    public void buyItem(Hero hero) {
        System.out.println("What kind of item would you like?");
        System.out.println("0. to Exit");
        System.out.println("1. Weapons");
        System.out.println("2. Armor");
        System.out.println("3. Potions");
        System.out.println("4. Spells");
        int choice = validateIntInput(0, 4), check = 0;
        String Choose = "";
        if (choice > 0)
            Choose = data.chooseItems(choice);
        else
            return;
        if (Choose.charAt(Choose.length() - 1) != '0' && choice > 3) {
            check = Integer.parseInt(Choose.charAt(Choose.length() - 1) + "");
            choice = check + 3;
            Choose = Choose;
        }
        System.out.println("Weapon you have chosen is " + Choose);
        //object to store items hero will buy
        RolePlayingGameItems wallet;
        switch (choice) {   //choose from item Type
            case 1:
                wallet = new Weapon();
                ((Weapon) wallet).setAttributes(Choose);
                break;
            case 2:
                wallet = new Armor();
                ((Armor) wallet).setAttributes(Choose);
                break;
            case 3:
                wallet = new Potion();
                ((Potion) wallet).setAttributes(Choose);
                break;
            case 4:
                wallet = new Spell();
                ((Spell) wallet).setAttributes(Choose, Spells.Ice);
                break;
            case 5:
                wallet = new Spell();
                ((Spell) wallet).setAttributes(Choose, Spells.Fire);
                break;
            case 6:
                wallet = new Spell();
                ((Spell) wallet).setAttributes(Choose, Spells.Lightning);
                break;
            default:
                wallet = new Weapon();
                break;
        }
        //check heros capability of buying item
        if (hero.getLvl() >= wallet.getRqLvl() && hero.getMoney() >= wallet.getCost()) {
            if (wallet instanceof Weapon) {
                hero.getWeapons().add((Weapon) wallet);
                hero.setMoney(hero.getMoney() - wallet.getCost());
            } else if (wallet instanceof Armor) {
                hero.getArmor().add((Armor) wallet);
                hero.setMoney(hero.getMoney() - wallet.getCost());
            } else if (wallet instanceof Potion) {
                hero.getPotions().add((Potion) wallet);
                hero.setMoney(hero.getMoney() - wallet.getCost());
            } else if (wallet instanceof Spell) {
                hero.getSpells().add((Spell) wallet);
                hero.setMoney(hero.getMoney() - wallet.getCost());
            }
            System.out.println("Successfully bought the following item = " + Choose);
            moneySpent = moneySpent + wallet.getCost();
        } else
            System.out.println("Hero is not yet capable to buying the item!");
    }

    //allow a hero to sell an item from their inventory
    public void sellItem(Hero hero) throws InterruptedException {
        hero.printInventory();
        System.out.println("What kind of item would you like to sell?");
        System.out.println("0. to Exit ");
        System.out.println("1. Weapons");
        System.out.println("2. Armor");
        System.out.println("3. Potions");
        System.out.println("4. Spells");
        int choice = validateIntInput(0, 4);
        RolePlayingGameItems toSell = new RolePlayingGameItems();
        System.out.println("Which one would you like to sell?");
        switch (choice) {
            case 0:
                System.out.println("Exiting...");
                delay();
                break;
            case 1:
                ArrayList<Weapon> weapon = hero.getWeapons();
                if (weapon.size() == 0) {
                    System.out.println("Hero doesn't have any to sell");
                    return;
                }
                for (int i = 0; i < weapon.size(); i++)
                    System.out.println(i + 1 + ". " + weapon.get(i));
                toSell = weapon.get(validateIntInput(0, weapon.size()) - 1);
                break;
            case 2:
                ArrayList<Armor> armour = hero.getArmor();
                if (armour.size() == 0) {
                    System.out.println("Hero doesn't have any to sell");
                    return;
                }
                for (int i = 0; i < armour.size(); i++)
                    System.out.println(i + 1 + ". " + armour.get(i));
                toSell = armour.get(validateIntInput(0, armour.size()) - 1);
                break;
            case 3:
                ArrayList<Potion> potion = hero.getPotions();
                if (potion.size() == 0) {
                    System.out.println("Hero doesn't have any to sell");
                    return;
                }
                for (int i = 0; i < potion.size(); i++)
                    System.out.println(i + 1 + ". " + potion.get(i));
                toSell = potion.get(validateIntInput(0, potion.size()) - 1);
                break;
            case 4:
                ArrayList<Spell> spell = hero.getSpells();
                if (spell.size() == 0) {
                    System.out.println("Hero doesn't have any to sell");
                    return;
                }
                for (int i = 0; i < spell.size(); i++)
                    System.out.println(i + 1 + ". " + spell.get(i));
                toSell = spell.get(validateIntInput(0, spell.size()) - 1);
                break;
        }

        //hero gets half of item original cost
        hero.setMoney(hero.getMoney() + (toSell.getCost() / 2));
        System.out.println("Successfully sold " + toSell.getName());

        //delete item from hero inventory
        if (toSell instanceof Weapon)
            hero.getWeapons().remove(toSell);
        else if (toSell instanceof Armor)
            hero.getArmor().remove(toSell);
        else if (toSell instanceof Potion)
            hero.getPotions().remove(toSell);
        else if (toSell instanceof Spell)
            hero.getSpells().remove(toSell);
    }

    //check if there is going to be a battle
    public void ifBattle(int x, int y) {
        if (rand.nextInt(rollADie) == 1)  //if it equals 1 -> start the battle (50%) chance
            battleBegins();
    }

    //method to start a battle sequence
    public void battleBegins() {
        System.out.println("----------------------------------");
        System.out.println("MONSTERS MEET HEROES IN BATTLE");
        System.out.println("----------------------------------");
        System.out.println(playerParty);
        //first generate monsters equal to size of hero party and highest level of hero party
        MonsterParty monsters = new MonsterParty(playerParty.getSize());

        for (int i = 0; i < monsters.getLength(); i++) {
            //get random monster
            String randomMonster = data.chooseMonsters(rand.nextInt(3) + 1, true);
            CreatureFactory createMonster = new CreatureFactory();
            Monster Mon = createMonster.createMonster(randomMonster, playerParty.getHighestLvl());  //pass highest level of hero to make new hero
            monsters.setPosition(i, Mon);
        }
        System.out.println(monsters);

        //fight till last man standing
        while (!monsters.allDead() && !playerParty.allDead()) {
            heroTurn(monsters);
            monsterTurn(monsters);

            //display creature info if any left alive
            System.out.println(playerParty);
            System.out.println(monsters);
        }
        if (monsters.allDead()) {
            System.out.println("!! THE HEROES HAVE WON !!");
            playerParty.winBattle(numberOfHeroes);  //declare winner for party and change hero stats
            numberOfLosses = numberOfLosses + numberOfHeroes - playerParty.numOfHeroesAlive();  //count losses

            playerParty.reviveTeam();   //revive hero with half HP
            numberOfWins++; //count wins
        }

        //if all heroes are dead in the party, monsters win and heroes lose
        else if (playerParty.allDead()) {
            System.out.println("The Heroes have died in war! Do not worry! You can try again in a new game!\n");
            numberOfLosses = numberOfLosses + numberOfHeroes - playerParty.numOfHeroesAlive();
            isGameOver = true;
        }
        //check if hero can level up
        playerParty.chkLevelUp();
    }

    //monster turn in battle
    public void monsterTurn(MonsterParty monsters) {
        int[] livingMonsters = monsters.aliveMonsters();  //store position of monsters which are alive
        //get the alive heroes and the alive monsters and set the enemys accordingly
        for (int i = 0; i < livingMonsters.length; i++) {
            int[] aliveHeroes = playerParty.aliveHeroes();
            int enemy = 0;
            for (int j = 0; j < aliveHeroes.length; j++) {
                if (Math.abs(livingMonsters[i] - enemy) >= Math.abs(livingMonsters[i] - aliveHeroes[j]))
                    enemy = aliveHeroes[j];
            }
            Monster currentMonster = monsters.getPosition(livingMonsters[i]);
            currentMonster.setEnemy(enemy);
            monsterAttack(currentMonster); //attack the enemy
        }
    }

    //allow the monster to attack its enemy
    public void monsterAttack(Monster monster) {
        //see if the monster dodges the attack
        Hero enemy = playerParty.getPosition(monster.getEnemy());
        if (rand.nextInt(100) + 1 <= enemy.calcDodge()) {
            System.out.println("The Hero Dodged it!");
        } else {
            //calculate damage based on equipped weapon
            int dmg = monster.calcDmg();
            enemy.takeDamage(dmg);
            System.out.println(monster.getName() + " has done a damage of " + dmg + " to " + enemy.getName());
            healthLoss = healthLoss + dmg;
        }
    }

    //the player's turn in battle
    public void heroTurn(MonsterParty monsters) {
        //get creatures that are alive and set them against each other
        int enemy = 0;
        int[] aliveHeroes = playerParty.aliveHeroes();
        for (int i = 0; i < aliveHeroes.length; i++) {
            int[] livingMonsters = monsters.aliveMonsters();    //get alive monsters
            if (livingMonsters.length == 0)  //if monsters are all dead
                break;
            for (int j = 0; j < livingMonsters.length; j++)
                enemy = j == 0 ? livingMonsters[j] : (Math.abs(aliveHeroes[i] - enemy) >= Math.abs(aliveHeroes[i] - livingMonsters[j]) ? livingMonsters[j] : 0);
            Hero currentHero = playerParty.getPosition(aliveHeroes[i]);
            currentHero.setEnemy(enemy);
            System.out.println("------------------------------------------------");
            System.out.println(currentHero.getName() + " is fighting with -> " + monsters.getPosition(currentHero.getEnemy()).getName());
            System.out.println("What would you like to do?");
            System.out.println("1. Attack");
            System.out.println("2. Use a Spell");
            System.out.println("3. Change Equipment");
            System.out.println("4. Use a Potion");
            int choice = validateIntInput(1, 4);
            if (choice == 1)
                heroAttack(currentHero, monsters);
            else if (choice == 2)
                useSpell(currentHero, monsters);
            else if (choice == 3)
                equipItem(currentHero);
            else if (choice == 4)
                usePotion(currentHero);
        }
    }

    //method to use potion if in inventory
    public void usePotion(Hero hero) {
        System.out.println("What potion would you like to use?");
        ArrayList<Potion> potions = hero.getPotions();
        //check if hero has potions
        if (potions.size() > 0) {
            for (int i = 0; i < potions.size(); i++)
                System.out.println(i + 1 + ". " + potions.get(i));
            int choice = validateIntInput(0, potions.size());
            hero.usePotion(choice - 1);
        } else
            System.out.println("No potions to use!");
    }

    //method to equip weapon or armor
    public void equipItem(Hero hero) {
        System.out.println("What would you like to equip?");
        System.out.println("0. Go back");
        System.out.println("1. Weapon");
        System.out.println("2. Armor");
        int choice = validateIntInput(0, 2);
        if (choice == 1) {
            System.out.println("Which weapon would you like to equip?");
            ArrayList<Weapon> weapons = hero.getWeapons();
            if (weapons.size() > 0) {
                for (int i = 0; i < weapons.size(); i++)
                    System.out.println(i + 1 + ". " + weapons.get(i));
                int choice2 = validateIntInput(0, weapons.size());  //equip weapon of choice
                hero.equipWeapon(choice2 - 1);
            } else
                System.out.println("Hero has no weapon in its inventory!");
        } else if (choice == 2) {
            System.out.println("Which armor would you like to equip?");
            ArrayList<Armor> armor = hero.getArmor();
            if (armor.size() > 0) {
                for (int i = 0; i < armor.size(); i++)
                    System.out.println(i + 1 + ". " + armor.get(i));
                int choice2 = validateIntInput(0, armor.size());    //equip armour of choice
                hero.equipArmor(choice2 - 1);
            } else
                System.out.println("Hero has no armour in its inventory!");
        }
    }

    //method to use spell
    public void useSpell(Hero hero, MonsterParty monsters) {
        Monster enemy = monsters.getPosition(hero.getEnemy());
        if (rand.nextInt(100) + 1 <= enemy.calcDodge())
            System.out.println("The Monster dodged the spell!");    //monster may dodge the spell
        else {
            ArrayList<Spell> spells = hero.getSpells();
            if (spells.size() > 0) {
                System.out.println("Choose a spell to use!\n");
                for (int i = 0; i < spells.size(); i++)
                    System.out.println(i + 1 + ". " + spells.get(i));
                int choice = validateIntInput(1, spells.size());
                Spell spell = spells.get(choice - 1);
                if (hero.useSpell(choice - 1)) {
                    int dmg = spell.getDmg() + ((hero.getDexterity() / 100000) * spell.getDmg());   //calculate spell damage
                    enemy.takeDamage(dmg);
                    System.out.println(hero.getName() + " has done a damage of " + dmg + " to " + enemy.getName());
                    //special effect of spell on monster
                    enemy.effectOfSpell(spell);
                }
            } else
                System.out.println("Hero has no spells in its inventory!");
        }
    }

    public void heroAttack(Hero hero, MonsterParty monsters) {
        //monster may dodge heros attack
        Monster enemy = monsters.getPosition(hero.getEnemy()); //for hero, monster is enemy
        if (rand.nextInt(100) + 1 <= enemy.calcDodge()) {
            System.out.println("The monster has dodged the hero's attack! :O");
        } else {
            //calculate damage based on the weapon the hero is carrying
            int dmg = hero.calcWpDmg();
            enemy.takeDamage(dmg);
            System.out.println(hero.getName() + " has done a damage of " + dmg + " to " + enemy.getName());
            System.out.println("------------------------------------");
        }
    }

    public void delay() throws InterruptedException {
        Thread.sleep(2000);
    }

    //Function to validateIntInput
    public int validateIntInput(int min, int max) {
        int input;
        while (true) {
            input = 0;
            System.out.println("Please enter your choice");
            myScanner = new Scanner(System.in);
            try {
                input = myScanner.nextInt();
                if (input > max || input < min)
                    System.out.println("Please enter a number between " + min + " and " + max);
                else
                    break;
            } catch (Exception e) {
                System.out.println("Please enter a numerical.");
            }
        }
        return input;
    }

    //Function to validateCharInput
    public String validateCharInput() {
        String input;
        while (true) {
            input = "";
            System.out.println("Please enter your choice!");
            myScanner = new Scanner(System.in);
            try {
                input += myScanner.next().charAt(0);
                input = input.toUpperCase();
                if (!(input.equals(goUp) || input.equals(goLeft) || input.equals(goDown) || input.equals(goRight) || input.equals(Info) || input.equals(quit) || input.equals(showInventory) || input.equals(showMap)))
                    System.out.println("Please enter a character from the Menu displayed.");
                else
                    break;
            } catch (Exception e) {
                System.out.println("Try again.");
            }
        }
        return input;
    }

    public void Statistics() {
        System.out.println("---------X----------------------X--------------------------X-------------X---------");
        System.out.println("\t\t\t\t\t\t\tStatistics");
        System.out.println("Number of moves\tNumber of Heroes\tNumber of Losses\tNumber of Wins\tNumber of times Markets visited\\ttTotal damage taken\tTotal money spent");
        System.out.println(moveStats + "\t\t\t\t\t" + numberOfHeroes + "\t\t\t\t\t" + numberOfLosses + "\t\t\t\t\t" + numberOfWins + "\t\t\t\t\t" + numberOfMarketsVisited + "\t\t\t\t\t\t\t" + healthLoss + "\t\t\t\t\t" + moneySpent);
        System.out.println("---------X----------------------X--------------------------X-------------X---------");
    }
}