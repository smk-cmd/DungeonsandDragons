public class Warlock extends EnemyDecorator implements Magical
{
    /* Constructs a Warlock class enemy
     * @param e The enemy obtaining the Warlock class title
     */
    public Warlock(Enemy e)
    {
        super(e, e.getName(), 1 + e.getHp());
    }

    /* Overrides the super class and allows the Warlock class enemies to randomly use one of three spells
     * @param e The entity being attacked
     * @return A description of the attack
     */
    public String attack(Entity e)
    {
        int magicAttack = (int)(Math.random() * 3);

        if (magicAttack == 0)
        {
            return magicMissile(e);
        }

        if (magicAttack == 1)
        {
            return fireball(e);
        }

        return thunderclap(e);
    }

    /* Adds the decorator title to the enemy's current name
     * @return The adjusted name of the enemy
     */
    public String getName()
    {
        return super.getName() + " Warlock";
    }

    /* Overrides the interface and allows the enemy to fire magic missiles
     * @param e The entity that is being attacked by magic damage
     * @return The String representing the damage done to the Hero
     */
    public String magicMissile(Entity e)
    {
        int dmg = (int)(Math.random() * 3);
        e.takeDamage(dmg);
        return " launched magic missiles at " + e.getName() + " for " + dmg + " damage.";
    }

    /* Overrides the interface and allows the enemy to use fireball
     * @param e The entity that is being attacked by magic damage
     * @return The String representing the damage done to the Hero
     */
    public String fireball(Entity e)
    {
        int dmg = (int)(Math.random() * 4);
        e.takeDamage(dmg);
        return " burned " + e.getName() + " with a fireball for " + dmg + " damage.";
    }

    /* Overrides the interface and allows the enemy to use the thunder clap spell
     * @param e The entity that is being attacked by magic damage
     * @return The String representing the damage done to the Hero
     */
    public String thunderclap(Entity e)
    {
        int dmg = (int)((Math.random() * 3) + 1);
        e.takeDamage(dmg);
        return " electrocuted " + e.getName() + " with Thunder Clap for " + dmg + " damage.";
    }
}
