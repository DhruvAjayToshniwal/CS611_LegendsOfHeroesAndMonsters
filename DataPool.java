import java.util.Random;
import java.util.Scanner;

//This class is to extract data from the text files
//I have just copy-pasted the data from the text files and created multiple methods to use this data
public class DataPool {
    Scanner myScanner;
    DataPool() {
        myScanner = new Scanner(System.in);
    }

    //method to validate integer input
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

    //method to choose a random monster
    //using boolean if user wants to select monster but not implemented yet
    String chooseMonsters(int choice, boolean rand) {
        String mons[] = new String[choice == 1 ? 12 : (choice == 2 ? 12 : 11)];
        switch (choice) {
            case 1:
                mons[0] = "Desghidorrah     3       300       400     35";
                mons[1] = "Chrysophylax     2       200       500     20";
                mons[2] = "BunsenBurner     4       400       500     45";
                mons[3] = "Natsunomeryu     1       100       200     10";
                mons[4] = "TheScaleless     7       700       600     75";
                mons[5] = "Kas-Ethelinh     5       600       500     60";
                mons[6] = "Alexstraszan     10      1000      9000    55";
                mons[7] = "Phaarthurnax     6       600       700     60";
                mons[8] = "D-Maleficent     9       900       950     85";
                mons[9] = "TheWeatherbe     8       800       900     80";
                mons[10] = "Igneel           6       600       400     60";
                mons[11] = "BlueEyesWhite    9       900       600     75";
                break;
            case 2:
                mons[0] = "Cyrrollalee     7       700        800     75";
                mons[1] = "Brandobaris     3       350        450     30";
                mons[2] = "BigBad-Wolf     1       150        250     15";
                mons[3] = "WickedWitch     2       250        350     25";
                mons[4] = "Aasterinian     4       400        500     45";
                mons[5] = "Chronepsish     6       650        750     60";
                mons[6] = "Kiaransalee     8       850        950     85";
                mons[7] = "St-Shargaas     5       550        650     55";
                mons[8] = "Merrshaullk     10      1000       900     55";
                mons[9] = "St-Yeenoghu     9       950        850     90";
                mons[10] = "DocOck          6       600        600     55";
                mons[11] = "Exodia          10      1000       1000    50";
                break;
            case 3:
                mons[0] = "Andrealphus     2       600       500     40";
                mons[1] = "Blinky          1       450       350     35";
                mons[2] = "Andromalius     3       550       450     25";
                mons[3] = "Chiang-shih     4       700       600     40";
                mons[4] = "FallenAngel     5       800       700     50";
                mons[5] = "Ereshkigall     6       950       450     35";
                mons[6] = "Melchiresas     7       350       150     75";
                mons[7] = "Jormunngand     8       600       900     20";
                mons[8] = "Rakkshasass     9       550       600     35";
                mons[9] = "Taltecuhtli     10      300       200     50";
                mons[10] = "Casper          1       100       100     50";
                break;
        }
        Random ran = new Random();
        if (rand == true && (choice == 1 || choice == 2))
            return mons[ran.nextInt(12)];
        else if (rand == true && (choice == 3))
            return mons[ran.nextInt(11)];
        return "";
    }

    //method to choose heroes as selected by user
    //using boolean value to choose randomly as well
    String chooseHeroes(int choice, boolean rand) {
        int ch = 0;
        System.out.println("Name    mana    strength    agility dexterity   starting money  starting experience");
        String mons[] = new String[6];
        switch (choice) {
            case 1:
                mons[0] = "Gaerdal_Ironhand    100     700     500     600     1354    7";
                mons[1] = "Sehanine_Monnbow    600     700     800     500     2500    8";
                mons[2] = "Muamman_Duathall    300     900     500     750     2546    6";
                mons[3] = "Flandal_Steelskin   200     750     650     700     2500    7";
                mons[4] = "Undefeated_Yoj      400     800     400     700     2500    7";
                mons[5] = "Eunoia_Cyn          400     700     800     600     2500    6";
                break;
            case 2:
                mons[0] = "Rillifane_Rallathil     1300    750     450     500     2500    9";
                mons[1] = "Segojan_Earthcaller     900     800     500     650     2500    5";
                mons[2] = "Reign_Havoc             800     800     800     800     2500    8";
                mons[3] = "Reverie_Ashels          900     800     700     400     2500    7";
                mons[4] = "Kalabar                 800     850     400     600     2500    6";
                mons[5] = "Skye_Soar               1000    700     400     500     2500    5";
                break;
            case 3:
                mons[0] = "Parzival             300     750     650     700     2500    7";
                mons[1] = "Sehanine_Moonbow     300     750     700     700     2500    7";
                mons[2] = "Skoraeus_Stonebones  250     650     600     350     2500    4";
                mons[3] = "Garl_Glittergold     100     600     500     400     2500    5";
                mons[4] = "Amaryllis_Astra      500     500     500     500     2500    5";
                mons[5] = "Caliber_Heist        400     400     400     400     2500    8";
                break;
        }
        for (int i = 1; i <= 6; i++)
            System.out.println(i + ". " + mons[i - 1]);
        if (rand == true) {
            return (mons[validateIntInput(1, 6) - 1]);
        } else {
            Random ran = new Random();
            return (mons[ran.nextInt(6)]);
        }
    }

    //method to choose items from data pool as selected
    String chooseItems(int choice) {
        String item[] = new String[choice == 1 ? 6 : (choice == 2 ? 5 : (choice == 4 ? 5 : 6))];
        int ch = 0;
        switch (choice) {
            case 1:
                System.out.println("Name    cost    level   damage  required hands");
                item[0] = "Sword           500     1    800    1";
                item[1] = "Bow             300     2    500    2";
                item[2] = "Scythe          1000    6    1100   2";
                item[3] = "Axe             550     5    850    1";
                item[4] = "TSwords         1400    8    1600   2";
                item[5] = "Dagger          200     1    250    1 ";
                break;
            case 2:
                System.out.println("Name    cost    required level  damage reduction");
                item[0] = "Platinum_Shield       150   1   200";
                item[1] = "Breastplate           350   3   600";
                item[2] = "Full_Body_Armor       1000  8   1100";
                item[3] = "Wizard_Shield         1200  10  1500";
                item[4] = "Guardian_Angel        1000  10  1000";
                break;
            case 3:
                System.out.println("Name    cost    required level  attribute increase  attribute affected");
                item[0] = "Healing_Potion  250     1   100  Health";
                item[1] = "Strength_Potion 200     1   75   Strength";
                item[2] = "Magic_Potion    350     2   100  Mana";
                item[3] = "Luck_Elixir     500     4   65   Agility";
                item[4] = "Mermaid_Tears   850     5   100  Health/Mana/Strength/Agility";
                item[5] = "Ambrosia        1000    8   150  All Health/Mana/Strength/Dexterity/Agility";
                break;
            case 4:
                //User selects what kind of spell he/she wants
                System.out.println("What kind of spell would you like?");
                System.out.println("1. Ice Spells");
                System.out.println("2. Fire Spells");
                System.out.println("3. Lightning Spells");
                ch = validateIntInput(1, 3);
                switch (ch) {
                    case 1:
                        item[0] = "Snow_Cannon     500     2   650     250";
                        item[1] = "Ice_Blade       250     1   450     100";
                        item[2] = "Frost_Blizzard  750     5   850     350";
                        item[3] = "Arctic_Storm    700     6   800     300";
                        break;
                    case 2:
                        item[0] = "Flame_Tornado   700     4   850     300";
                        item[1] = "Breath_of_Fire  350     1   450     100";
                        item[2] = "Heat_Wave       450     2   600     150";
                        item[3] = "Lava_Comet      800     7   1000    550";
                        item[4] = "Hell_Storm      600     3   950     600";
                        break;
                    case 3:
                        item[0] = "Lightning_Dagger      400        1       500     150";
                        item[1] = "Thunder_Blast         750        4       950     400";
                        item[2] = "Electric_Arrows       550        5       650     200";
                        item[3] = "Spark_Needles         500        2       600     200";
                        break;
                }
                break;
        }
        if (choice == 4) {
            System.out.println("Name    cost    required level  damage  mana cost");
            for (int i = 0; i < item.length; i++) {
                if (!(item[i] == null))
                    System.out.println(i + 1 + ". " + item[i]);
            }
            if (ch == 1)
                return (item[validateIntInput(1, 4) - 1] + "1");
            if (ch == 2)
                return (item[validateIntInput(1, 5) - 1] + "2");
            if (ch == 3)
                return (item[validateIntInput(1, 4) - 1] + "3");
        } else {
            for (int i = 1; i <= item.length; i++)
                System.out.println(i + ". " + item[i - 1]);
            if (choice == 2)
                return (item[validateIntInput(1, 5) - 1]);
            else
                return (item[validateIntInput(1, 6) - 1]);
        }
        return "";
    }
}