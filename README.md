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
