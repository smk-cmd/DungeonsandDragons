public class Warrior extends EnemyDecorator
{
    /* Constructs a Warrior class enemy
     * @param e The enemy obtaining the Warrior class title
     */
    public Warrior(Enemy e)
    {
        super(e, e.getName(), 2 + e.getHp());
    }

    /* Overrides the super class and allows the Warrior class enemies to attack
     * @param e The entity being attacked
     * @return A description of the attack
     */
    public String attack(Entity e)
    {
        int dmg = (int)((Math.random() * 3) + 1);
        e.takeDamage(dmg);
        return " attacked " + e.getName() + " for " + dmg + " damage.";
    }

    /* Adds the decorator title to the enemy's current name
     * @return The adjusted name of the enemy
     */
    public String getName()
    {
        return super.getName() + " Warrior";
    }
}
