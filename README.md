# CS611_LegendsOfHeroesAndMonsters
CS611 03
Legends: Monsters and Heroes
---------------------------------------------------------------------------
Dhruv Toshniwal
dhruvt@bu.edu
U28189255

AccessibleTile.java = class to define accessible tiles
AllHeroes.java = class that overrides levelUp stats. Set according to hero types
Armor.java = Armour class contains stats for armour. Extends RolePlayingGameItems class
Board.java = board class that can be extended
BoardGame.java = Game rules defined in this class
Creature.java = Hero or monster, both are creature and has initial starting stats similar
CreatureFactory.java = Class that creates both monsters and heroes
DataPool.java = Dictionary class from text files
Hero.java = Individual hero class, extended from creature. Has hero attributes
HeroTypes.java = an enum class to specify types of heroes
InAccessibleTile.java = class to define inaccessible tiles
LegBoard.java = legends board, extends board and defines player party location and tile attributes
Legends.java = main class where all functionalities are called
LegTile.java = base tile for all tile types
MarketTile.java = class to define market tiles
Monster.java = Individual monster class, extended from creature. Has monster attributes
MonsterParty.java = define monsters party like hero party
Play.java = main method to call legends class
Potion.java = type of RolePlayingGameItems item
RolePlayingGameItems.java = base class for all game items
RolePlayingPartyHeroOrMonster.java = base class for creature (hero or monster) methods
Spell.java = type of RolePlayingGameItems item
Spells.java = enum class to define spell types
Tile.java = base tile class for board games
Weapon.java = type of RolePlayingGameItems item

Compilation instructions:
javac *.java
java Play

Input/Output:

Welcome to the World of Legends: Monsters v/s Heroes!
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠊⠁⠀⠀⠉⢳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⠀⠀⠀⠀⠀⢢⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢱⢶⠆⠛⠁⠀⠸⢊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠨⠔⠀⠀⠔⢠⣏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣣⠙⠁⠀⢀⡆⢻⡶⡤⣄⣠⣤⣀⡀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⡠⠾⠙⣳⡶⠚⢹⠣⢀⢵⠾⢟⠉⠁⠓⠽⢷⡀⠀⠀
⠀⠀⠀⠀⢀⠤⠒⠓⠲⠶⡄⠈⠐⠒⠺⢶⣿⣗⠤⠀⢰⠀⠀⠀⠀⣧⠀⠀
⠀⠀⠀⢀⠃⠀⠀⠀⠀⠀⡃⠀⠀⠀⠐⠙⢻⡄⠀⠀⠘⣦⣄⠀⠐⠛⢆⠀
⠀⠀⢀⣌⠀⠀⠀⠀⠀⣼⠁⠀⠀⠀⠀⠒⠒⣿⠉⠀⠀⣿⢠⠀⠀⠀⠙⡆
⠀⡰⠋⠀⢀⠀⠈⠉⢻⣿⣦⡄⡀⠀⠀⠀⠴⣾⣏⣁⣠⣿⡈⣣⠀⢀⣇⢰
⠀⣇⡔⠀⠀⡇⣀⣀⣾⠃⠈⠛⠶⠶⣴⠶⠋⠁⢄⠈⠙⣿⡟⠁⠀⠀⠘⢈
⢰⡟⠀⠀⠐⢿⠻⣿⣯⡓⠂⠀⠀⠀⢸⠀⠀⠀⢘⣆⡠⠟⠓⠂⠀⢀⡠⠜
⢸⡟⣖⠀⠀⠀⠑⡘⢿⣿⡆⠀⢀⠤⠤⠤⣤⡤⠞⠉⠀⠀⣀⠠⡶⠋⠀⠀
⠀⠙⠮⣢⡤⣀⠀⠐⠠⣹⡇⢀⣋⡌⢀⡀⠀⠀⣀⣄⣀⠥⠐⠊⠀⠀⠀⠀
⠀⠀⠀⠈⠉⠓⠧⣤⣄⠀⠉⠁⠐⢌⡹⣿⡶⠾⡟⠁⣿⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣆⡀⠀⠤⢰⢿⡄⠀⠁⠀⡿⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢰⠟⠉⠉⠛⣶⣶⣷⠈⠺⠆⠀⢠⣧⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠘⠛⠛⠓⠀⠀⠀⠈⠙⠂⠀⠀⠀⠀⠀⠀




⡿⠉⣉⡁⠈⠁⢀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠇⢉⣿⢇⣀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠏⠉⠻⣯⠍⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣮⣿⣶⣤⢀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠋⠀⠉⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠀⢀⠴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠠⣼⣥⣴⣾⠟⣻⣿⢿⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⠀⠀⠀⠀⠉⢻⣿⣿⣄⡛⠛⣨⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣄⡀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⡟⠟⠟⣦⠙⣇⣀⡄⠀⠀⠀⠈⠛⠿⠿⠿⠿⢿⠟⠛⠀⢀⡀⠀⠀⠀⠀⣴⣾⡟⢛⣿⣿⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⡇⠘⢀⣩⣆⣼⠉⢿⣄⠀⣀⣀⡀⢀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡟⠉⣲⡄⡿⣿⣧⣌⣋⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣧⢠⣾⣉⣛⢸⠀⢦⣿⣿⣿⣉⣉⡀⠀⠀⠀⠀⠀⠀⠐⢻⠟⠃⢠⣿⠇⠀⠈⠛⠛⠛⠋⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣧⣙⠺⠙⣿⡄⠀⠘⡍⢻⣿⣿⣷⣶⣶⣤⣤⣤⣀⣀⠘⠂⠀⠈⠃⠀⠀⠀⠀⢀⠀⠀⡘⠻⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣿⡇⠀⠀⠁⠈⣿⣿⣿⣿⣿⣿⡿⡿⡿⣿⣿⣿⣶⣤⣤⣤⣄⣀⠀⢀⣷⣾⠖⠉⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢷⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣾⣿⣿⣥⣿⣏⣿⣻⠻⣿⣿⣿⡿⣿⡟⠰⢠⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠘⣧⠀⠂⢀⠀⠈⠉⢿⣿⣥⣏⡿⣿⣿⣿⣿⣿⣿⣷⣶⣿⣿⠛⢡⠟⢁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⢀⢻⣧⠀⡌⠀⠀⠀⠀⢻⣿⣿⣷⣯⣹⡟⣝⣛⣯⣽⣿⡟⠁⢠⣯⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⢸⢿⣿⣧⣼⣷⠀⠀⠀⠀⡙⠻⣿⣿⣿⣿⣿⣿⣿⠟⠋⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⡟⠀⠘⡃⢹⣿⣿⣮⣧⠀⠀⠀⠈⠁⠉⠌⣉⣙⡻⠋⠁⡀⣀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠛⠛⠛⠛⠋⠉⠉⠉⠀⢠⡞⠀⠀⢀⡇⠘⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠇⢠⠀⢨⡇⠀⠋⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⣠⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠸⡅⠀⠀⠘⠿⣿⣿⣿⣿⣷⣶⣶⣤⣤⣤⣴⢋⢺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠉⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⡜⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠀⢀⠀⠀⠀⠀⠀⢳⣶⣾⣿⣿⣿⣿⣿⡏⠀⠀⡰⠁⠀⠈⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡀⣶⣽⣿⣿⣿⣿⡟⡍⡀⠀⠀⠁⠀⠀⠀⠀⠀⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
Building the Board...

| P | M |   | M |   | N | N |   |
|   | N |   |   | M |   |   | N |
| M | M |   |   |   |   |   |   |
|   |   | M |   |   | N |   | N |
| N |   | N |   | M |   |   | N |
|   | N | N | N | M | M |   |   |
| M |   |   | M |   | M | M | M |
| M | M | M |   |   |   | M | M |

Do you want another board?
1. for Y
2. for N
Please enter your choice
INPUT: 2

Please enter the number of heroes for your party!
Max number of heroes you can have is 3
Please enter your choice
INPUT: 1

What hero would you like?
1. for Warrior
2. for Sorcerer
3. for Paladin
Please enter your choice
INPUT: 3

Checking the database...
Name    mana    strength    agility dexterity   starting money  starting experience
1. Parzival             300     750     650     700     2500    7
2. Sehanine_Moonbow     300     750     700     700     2500    7
3. Skoraeus_Stonebones  250     650     600     350     2500    4
4. Garl_Glittergold     100     600     500     400     2500    5
5. Amaryllis_Astra      500     500     500     500     2500    5
6. Caliber_Heist        400     400     400     400     2500    8
Please enter your choice
INPUT: 2

Your hero is:
Sehanine_Moonbow     300     750     700     700     2500    7

Your current party
Sehanine_Moonbow	LV: 1	HP: 100	Mana:300	Str: 750	Agl: 700	Dex: 700	Money: 2500	Exp: 7	Wpn: 	Armor: 	


!! LET THE GAMES BEGIN !!

| P | M |   | M |   | N | N |   |
|   | N |   |   | M |   |   | N |
| M | M |   |   |   |   |   |   |
|   |   | M |   |   | N |   | N |
| N |   | N |   | M |   |   | N |
|   | N | N | N | M | M |   |   |
| M |   |   | M |   | M | M | M |
| M | M | M |   |   |   | M | M |

--------------------------------------------------
Enter W to move up.
Enter A to move left.
Enter S to move down.
Enter D to move right.
Enter I to see Hero Info
Enter Q to quit.
Enter E to manage inventory.
Enter M to show the Map
--------------------------------------------------
Please enter your choice!
INPUT: d

|   | P |   | M |   | N | N |   |
|   | N |   |   | M |   |   | N |
| M | M |   |   |   |   |   |   |
|   |   | M |   |   | N |   | N |
| N |   | N |   | M |   |   | N |
|   | N | N | N | M | M |   |   |
| M |   |   | M |   | M | M | M |
| M | M | M |   |   |   | M | M |

------------------------------------
You are near a market
What would you like to do?
1. Enter the market
2. Continue

Please enter your choice
INPUT: 2
--------------------------------------------------
Enter W to move up.
Enter A to move left.
Enter S to move down.
Enter D to move right.
Enter I to see Hero Info
Enter Q to quit.
Enter E to manage inventory.
Enter M to show the Map
--------------------------------------------------
Please enter your choice!
INPUT: q

Thank you for playing!
Here are your statistics for the game


---------X----------------------X--------------------------X-------------X---------
							Statistics
Number of moves	Number of Heroes	Number of Losses	Number of Wins	Number of times Markets visited	Total damage taken
1					1		0			0				0					0
---------X----------------------X--------------------------X-------------X---------

Process finished with exit code 0


INSTRUCTIONS:

If there is no place for the player party to move at the initiation of the Board, then opt for a new board.

Select hero(s).

Enter W to move up.
Enter A to move left.
Enter S to move down.
Enter D to move right.
Enter I to see Hero Info
Enter Q to quit.
Enter E to manage inventory.
Enter M to show the Map

TO TRAVERSE THROUGH THE MAP

ENTER Q to quit the game
