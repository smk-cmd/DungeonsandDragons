public class Orc extends Enemy
{
    /* Constructs an Orc object with a set max HP
     */
    public Orc()
    {
        super("Orc", 4);
    }

    /* Overrides the super class and allows the enemy to use a randomized attack
     * @param e The entity that is being attacked
     * @return The String containing the amount of damage the enemy inflicted
     */
    public String attack(Entity e)
    {
        int dmg = (int)(Math.random() * 5);
        e.takeDamage(dmg);
        return " attacked " + e.getName() + " for " + dmg + " damage.";
    }
}
