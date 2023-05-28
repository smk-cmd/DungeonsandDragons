public abstract class Entity
{
    private String name;
    private int maxHp;
    private int hp;

    /* Constructs an entity by giving it a name and health points
     * @param n The name of the entity
     * @param mHp The max health of the entity
     */
    public Entity(String n, int mHp)
    {
        name = n;
        maxHp = mHp;
        hp = mHp;
    }

    /* An abstract method that lets the entity attack
     * @param e The entity being attacked
     * @return The String containing the amount of damage that has been inflicted
     */
    public abstract String attack(Entity e);

    /* This returns the name of the entity
     * @return The String containing the entity's name
     */
    public String getName()
    {
        return name;
    }

    /* This returns the current hp of the entity
     * @return The int value of the entity's current health
     */
    public int getHp()
    {
        return hp;
    }

    /* This returns the max hp of the entity
     * @return The int value of the entity's max health
     */
    public int getMaxHp()
    {
        return maxHp;
    }

    /* Adds points back to the entity's health based on the amount healed
     * @param h The int value of the heal
     */
    public void heal(int h)
    {
        hp = hp + h;
        if (hp > maxHp)
        {
            hp = maxHp;
        }
    }

    /* Deducts points from the entity's health based on the damage dealt
     * @param d The int value of the damage received
     */
    public void takeDamage(int d)
    {
        hp = hp - d;
        if(hp < 0)
        {
            hp = 0;
        }
    }

    /* Prints out the name and health points of the entity
     * @return A string describing the entity's status
     */
    public String toString()
    {
        return getName() + "\nHP: " + hp + "/" + maxHp;
    }
}
