public class Troll extends Enemy
{
    /* Constructs a Troll object with a set max HP
     */
    public Troll()
    {
        super ("Troll", 5);
    }

    /* Overrides the super class and allows the enemy to use a randomized attack
     * @param e The entity that is being attacked
     * @return The String containing the amount of damage the enemy inflicted
     */
    public String attack(Entity e)
    {
        int dmg = (int)(Math.random() * 6);
        e.takeDamage(dmg);
        return " attacked " + e.getName() + " for " + dmg + " damage.";
    }
}
