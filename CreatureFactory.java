public class CreatureFactory {
    public CreatureFactory() {
    }
    //method to create Monster of any type
    //info of monster and maximum level of hero is sent
    public Monster createMonster(String infoOfMonster, int maxLevel) {
        Monster newMonster = new Monster();
        //set attributes
        newMonster.setAttributes(infoOfMonster);
        //match target level
        newMonster.matchLevelOfHero(maxLevel);
        return newMonster;
    }

    //method to create Hero of type sent to method
    public Hero createHero(int type) {
        Hero newHero;
        switch (type) {
            case 2:
                newHero = new AllHeroes(HeroTypes.Sorcerer);
                break;
            case 3:
                newHero = new AllHeroes(HeroTypes.Paladin);
                break;
            default:
                newHero = new AllHeroes(HeroTypes.Warrior);
                break;
        }
        return newHero;
    }
}