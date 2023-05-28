public class EnemyGenerator
{
    /* It is a factory that randomly generates an enemy and gives it a class depending on the Hero's level
     * @param level The int value of the Hero's current level
     * @return The randomly generated enemy object
     */
    public Enemy generateEnemy(int level)
    {
        int monsterRand = (int)(Math.random() * 4);
        int decorRand = (int)(Math.random() * 2);
        Enemy mon = new Troll();

        if (monsterRand == 0)
        {
            mon = new Goblin();
        }

        else if (monsterRand == 1)
        {
            mon = new Froglok();
        }

        else if (monsterRand == 2)
        {
            mon = new Orc();
        }

        else
        {
            mon = new Troll();
        }

        for (int i = 1; i < level; i++)
        {
            if (decorRand == 0)
            {
                mon = new Warrior(mon);
            }

            else
            {
                mon = new Warlock(mon);
            }
        }

        return mon;
    }
}
