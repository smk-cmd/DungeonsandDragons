public class Hero extends Entity implements Magical
{
    private Point loc;
    private int level;
    private int gold;
    private int key;

    /* Constructs a Hero by using the super class. Gives them a starting level and creates an instance of a map
     * @param n The name of the Hero
     * @param maxHp The Hero's max health
     */
    public Hero(String n)
    {
        super(n, 75);
        level = 1;
        Map.getInstance().loadMap(level);
        loc = Map.getInstance().findStart();
        gold = 50;
        key = 0;
    }

    /* Converts the hero's status, the instance of the map, and additional information into a string by using the super class
     * @return The Hero's status which contains their name, level, health points, and instance of the map
     */
    public String toString()
    {
        return super.toString() + "\nLevel: " + level + "\n" + Map.getInstance().mapToString(loc);
    }

    /* Increases the Hero's level every time they reach the floor's exit
     */
    public void levelUp()
    {
        level = level + 1;
        int mapNum = ((level + 2) % 3) + 1;
        Map.getInstance().loadMap(mapNum);
        loc = Map.getInstance().findStart();
    }

    /* Returns the hero's current level
     * @return The int value of the Hero's current level
     */
    public int getLevel()
    {
        return level;
    }

    /* Returns the hero's current location
     * @return The Point object containing the hero's current coordinate location
     */
    public Point getLoc()
    {
        return loc;
    }

    /* Increments the Hero's location to the north by one
     * @return The char value of the room the Hero is now in
     */
    public char goNorth()
    {
        loc.addX(-1);
        char next = Map.getInstance().getCharAtLoc(loc);
        return next;
    }

    /* Increments the Hero's location to the south by one
     * @return The char value of the room the Hero is now in
     */
    public char goSouth()
    {
        loc.addX(1);
        char next = Map.getInstance().getCharAtLoc(loc);
        return next;
    }

    /* Increments the Hero's location to the west by one
     * @return The char value of the room the Hero is now in
     */
    public char goWest()
    {
        loc.addY(-1);
        char next = Map.getInstance().getCharAtLoc(loc);
        return next;
    }

    /* Increments the Hero's location to the east by one
     * @return The char value of the room the Hero is now in
     */
    public char goEast()
    {
        loc.addY(1);
        char next = Map.getInstance().getCharAtLoc(loc);
        return next;
    }

    /* Returns the amount of gold the hero is currently carrying
     * @return The int value of the Hero's gold
     */
    public int getGold()
    {
        return gold;
    }

    /* Adds the amount of gold the hero found to their total
     * @param g The amount of gold the player found
     */
    public void collectGold(int g)
    {
        gold += g;
    }

    /* Subtracts the amount of gold the hero spent from their total
     * @param g The amount of gold the player spent
     */
    public void spendGold(int g)
    {
        gold -= g;
    }

    /* Checks to see if the hero currently has any keys in their inventory
     * @return The boolean value indicating whether or not the player has a key
     */
    public boolean hasKey()
    {
        if (key > 0)
        {
            return true;
        }

        return false;
    }

    /* Increments the amount of keys the hero has when he purchases or finds a key
     */
    public void pickUpKey()
    {
        key += 1;
    }

    /* Lets the hero use a key if they have one in their inventory
     * @return The boolean value indicating whether or not the player has any keys
     */
    public boolean useKey()
    {
        if (key > 0)
        {
            key -= 1;
            return true;
        }

        return false;
    }

    /* Overrides the super class and allows the Hero to deal a randomized amount of damage
     * @param e The entity that is being attacked
     * @return The String containing the amount of damage the Hero inflicted
     */
    public String attack(Entity e)
    {
        int dmg = (int)((Math.random() * 2) + 1);
        e.takeDamage(dmg);
        return " attacked " + e.getName() + " for " + dmg + " damage.";
    }

    /* Overrides the interface and allows the Hero to fire magic missiles
     * @param e The entity that is being attacked by magic damage
     * @return The String representing the damage done to the entity
     */
    public String magicMissile(Entity e)
    {
        int dmg = (int)((Math.random() * 2) + 1);
        e.takeDamage(dmg);
        return " fired their magic missiles at the " + e.getName() + " for " + dmg + " damage!";
    }

    /* Overrides the interface and allows the Hero to use fireball
     * @param e The entity that is being attacked by magic damage
     * @return The String representing the damage done to the entity
     */
    public String fireball(Entity e)
    {
        int dmg = (int)((Math.random() * 3) + 1);
        e.takeDamage(dmg);
        return " decimated the " + e.getName() + " with a fireball for " + dmg + " damage!";
    }

    /* Overrides the interface and allows the Hero to use the thunder clap spell
     * @param e The entity that is being attacked by magic damage
     * @return The String representing the damage done to the entity
     */
    public String thunderclap(Entity e)
    {
        int dmg = (int)((Math.random() * 50) + 51);
        e.takeDamage(dmg);
        return " *CLAPPED* the " + e.getName() + " for " + dmg + " damage!!";
    }
}
