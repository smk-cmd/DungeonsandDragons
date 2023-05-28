/* Austin H Kim
 * Shane Khan
 * Fernando Marquez-Hernandez
 * 5/2/2021
 * Project 2 - This is a dungeon crawler game where the player must try to traverse and fight their way through the tower.
 */

public class Main
{
    public static void main(String[]args)
    {
        System.out.println("Hello traveler. What is your name?");
        String name = CheckInput.getString();
        Hero protag = new Hero(name);
        System.out.println(protag.toString());

        char room = ' ';
        boolean alive = true;

        while (alive)
        {
            System.out.println("1. Go North\n2. Go South\n3. Go East\n4. Go West\n5. Quit");
            int choice = CheckInput.getIntRange(1,5);
            Map.getInstance().reveal(protag.getLoc());
            Map.getInstance().removeCharAtLoc(protag.getLoc());

            if (choice == 1)
            {
                room = protag.goNorth();
            }

            if (choice == 2)
            {
                room = protag.goSouth();
            }

            if (choice == 3)
            {
                room = protag.goEast();
            }

            if (choice == 4)
            {
                room = protag.goWest();
            }

            if (choice == 5)
            {
                System.out.println("Game Over...coward");
                break;
            }

            if (room == 's')
            {
                store(protag);
            }

            if (room == 'n')
            {
                System.out.println("There was nothing here\n");
            }

            if (room == 'm')
            {
                EnemyGenerator foes = new EnemyGenerator();
                Map.getInstance().reveal(protag.getLoc());
                alive = monsterRoom(protag, foes.generateEnemy(protag.getLevel()));
            }

            if (room == 'i')
            {
                int randKey = (int)(Math.random() * 3);
                protag.heal(25);
                System.out.println("You found a health potion! Down the hatch\n-You restored 25 hp-\n");

                if (randKey > 0)
                {
                    System.out.println("...you see something a glimmer underneath some rubble");
                    System.out.println("-A key was added to your inventory-\n");
                    protag.pickUpKey();
                }
            }

            if (room == 'f')
            {
                if (protag.hasKey())
                {
                    protag.levelUp();
                    protag.useKey();
                    System.out.println("You found the exit and unlocked the door. Proceeding to the next floor.\n");
                }

                else
                {
                    System.out.println("The door's locked. There must be a key around here somewhere...");
                }
            }

            if (alive)
            {
                System.out.println(protag.toString());
            }
        }

        if (!alive)
        {
            System.out.println("\nGame Over\nYou died :c");
        }
    }

    /* Displays the enemy and prompts the player to either fight or run
     * @param h The player's Hero object
     * @param e The randomized enemy object
     * @return A boolean value showing whether or not the Hero is alive
     */
    public static boolean monsterRoom(Hero h, Enemy e)
    {
        System.out.println("You've encountered " + e.getName()+ "\n" + e.toString());
        System.out.println("1. Fight\n2. Run");
        int choice = CheckInput.getIntRange(1,2);

        if (choice == 1)
        {
            return fight(h, e);
        }

        System.out.println("You ran away like a coward\n");
        int direction = (int)((Math.random() * 4) + 1);

        if (direction == 1)
        {
            h.goNorth();
        }

        if (direction == 2)
        {
            h.goSouth();
        }

        if (direction == 3)
        {
            h.goEast();
        }

        if (direction == 4)
        {
            h.goWest();
        }

        return true;
    }

    /* Allows the player to choose their attack and simulates a battle between the Hero and the enemy
     * @param h The player's Hero object
     * @param e The randomized enemy object
     * @return A boolean value showing whether or not the Hero is alive
     */
    public static boolean fight(Hero h, Enemy e)
    {
        int randGold = (int)((Math.random() * 8) + 3);

        while (e.getHp() != 0)
        {
            System.out.println("1. Physical Attack\n2. Magical Attack");

            int choice = CheckInput.getIntRange(1, 2);

            if (choice == 1)
            {
                System.out.println(h.getName() + h.attack(e));
            }

            if (choice == 2)
            {
                System.out.println(h.MAGIC_MENU);
                int magicChoice = CheckInput.getIntRange(1, 3);

                if (magicChoice == 1)
                {
                    System.out.println(h.getName() + h.magicMissile(e));
                }

                if (magicChoice == 2)
                {
                    System.out.println(h.getName() + h.fireball(e));
                }

                if (magicChoice == 3)
                {
                    System.out.println(h.getName() + h.thunderclap(e));
                }
            }

            if (e.getHp() > 0)
            {
                for (int i = 0; i < h.getLevel(); i++)
                {
                    System.out.println(e.getName() + e.attack(h));
                }
            }

            if (h.getHp() == 0)
            {
                return false;
            }

            System.out.println(e.toString());
        }

        h.collectGold(randGold);
        System.out.println("You defeated the " + e.getName() + "!\nIt dropped " + randGold + " gold.\n");
        return true;
    }

    /* Lets the player visit the store to make a purchase or leave without buying anything
     * @param h The player's Hero object
     */
    public static void store(Hero h)
    {
        int choice = 0;
        System.out.println("Welcome! What're ya buying?");

        while (choice != 3)
        {
            System.out.println("Gold: " + h.getGold() + "\n1. Buy potion\n2. Buy key\n3. Exit store");
            choice = CheckInput.getIntRange(1, 3);

            if (choice == 1)
            {
                if (h.getGold() >= 25)
                {
                    h.heal(25);
                    h.spendGold(25);
                    System.out.println("Heh heh heh... Thank you!\nAnything else stranger?");
                }

                else
                {
                    System.out.println("Not enough cash stranger! Anything else?");
                }
            }

            if (choice == 2)
            {
                if (h.getGold() >= 50)
                {
                    h.pickUpKey();
                    h.spendGold(50);
                    System.out.println("Good choice! Anything else stranger?");
                }

                else
                {
                    System.out.println("Not enough cash stranger! Anything else?");
                }
            }
        }

        System.out.println("Come back anytime stranger!\n");
    }
}
